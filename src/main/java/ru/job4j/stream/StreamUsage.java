package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, -5, 9, 10, -3, -6);
        List<Integer> resultList = list.stream().filter(x -> x > 0).collect(Collectors.toList());
        System.out.println(resultList);
    }
}
