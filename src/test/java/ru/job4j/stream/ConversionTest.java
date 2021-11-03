package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ConversionTest {

    @Test
    public void whenConvertToMap() {
        List<Student> in = List.of(
                new Student(5, "Volkov"),
                new Student(5, "Volkov"),
                new Student(3, "Petrov")
        );
        Map<String, Student> rsl = Conversion.convertToMap(in);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Volkov", new Student(5, "Volkov"));
        expected.put("Petrov", new Student(3, "Petrov"));
        assertEquals(rsl, expected);
    }
}