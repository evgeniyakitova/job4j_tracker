package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = List.of(
                new Student(28, "Masha"),
                new Student(128, "Pety")
        );
        List<Student> expected = List.of(
                new Student(128, "Pety"),
                new Student(28, "Masha")
        );
        assertThat(StudentLevel.levelOf(input, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student(28, "Pety"));
        List<Student> expected = List.of(new Student(28, "Pety"));
        assertThat(StudentLevel.levelOf(input, 10), is(expected));
    }

    @Test
    public void whenSortedAndFilter() {
        List<Student> input = List.of(
                new Student(28, "Masha"),
                new Student(60, "Mike"),
                new Student(100, "Nik"),
                new Student(20, "Victor")
        );
        List<Student> expected = List.of(
                new Student(100, "Nik"),
                new Student(60, "Mike")
        );
        assertThat(StudentLevel.levelOf(input, 50), is(expected));
    }
}