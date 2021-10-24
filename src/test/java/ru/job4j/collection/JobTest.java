package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenAscByName() {
        int result = new JobAscByName().compare(new Job("First task", 1),
                new Job("Second Task", 2));
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenDescByName() {
        int result = new JobDescByName().compare(new Job("First task", 1),
                new Job("Second Task", 2));
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenAscByPriority() {
        int result = new JobAscByPriority().compare(new Job("First task", 2),
                new Job("Second Task", 1));
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenDescByPriority() {
        int result = new JobDescByPriority().compare(new Job("First task", 2),
                new Job("Second Task", 1));
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenDescByNameAndPriority() {
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = comparator.compare(
                new Job("TaskX", 1),
                new Job("TaskX", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAscByNameAndPriority() {
        Comparator<Job> comparator = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = comparator.compare(
                new Job("Task", 1),
                new Job("TaskX", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}