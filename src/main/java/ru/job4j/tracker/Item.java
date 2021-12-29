package ru.job4j.tracker;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Item {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private int id;
    private String name;
    private LocalDateTime created;

    public Item() {

    }

    public Item(String name) {
        this.name = name;
        created = LocalDateTime.now();
    }

    public Item(String name, int id) {
        this(name);
        this.id = id;
    }

    public Item(String name, int id, LocalDateTime created) {
        this(name, id);
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id && Objects.equals(name, item.name)
                && Objects.equals(created, item.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created);
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + created.format(FORMATTER) + '}';
    }
}