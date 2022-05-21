package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Item itemInDB = session.get(Item.class, id);
            if (itemInDB != null) {
                item.setId(id);
                session.merge(item);
                result = true;
            }
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            int count = session.createQuery("delete from Item where id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            result = count > 0;
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from Item", Item.class).list();
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String name) {
        List<Item> result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from Item as item where item.name = :name", Item.class)
                    .setParameter("name", name)
                    .list();
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Item result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            result = session.get(Item.class, id);
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (sf != null) {
            sf.close();
        }
    }
}
