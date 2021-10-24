package ru.job4j.collection;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortByIdTest {

    @Test
    public void whenAscSort() {
        Item first = new Item("test1", 1);
        Item second = new Item("test2", 2);
        Item third = new Item("test3", 3);
        List<Item> items = Arrays.asList(second, third, first);
        Collections.sort(items, new AscSortById());
        List<Item> expected = Arrays.asList(first, second, third);
        assertEquals(expected, items);
    }

    @Test
    public void whenDescSort() {
        Item first = new Item("test1", 1);
        Item second = new Item("test2", 2);
        Item third = new Item("test3", 3);
        List<Item> items = Arrays.asList(second, third, first);
        Collections.sort(items, new DescSortById());
        List<Item> expected = Arrays.asList(third, second, first);
        assertEquals(expected, items);
    }
}
