package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Conversion {
    public static Map<String, Student> convertToMap(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(Student::getSurname, s -> s, (s1, s2) -> s2));
    }
}
