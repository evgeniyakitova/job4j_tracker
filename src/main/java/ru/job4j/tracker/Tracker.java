package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] arrayOfKey = new Item[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (key.equals(item.getName())) {
                arrayOfKey[index] = item;
                index++;
            }
        }
        return Arrays.copyOf(arrayOfKey, index);
    }

    public Item[] findAll() {
        Item[] arrayWithoutNull = new Item[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item != null) {
                arrayWithoutNull[index] = item;
                index++;
            }
        }
        return Arrays.copyOf(arrayWithoutNull, index);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
        item.setId(id);
        items[index] = item;
        }
        return result;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items[index] = null;
            int start = index + 1;
            int length = size - index - 1;
            System.arraycopy(items, start, items, index, length);
            items[size - 1] = null;
            size--;
        }
        return result;
    }
}