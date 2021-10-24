package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int firstNum = Integer.parseInt(s1.split("\\.")[0]);
        int secondNum = Integer.parseInt(s2.split("\\.")[0]);
        return Integer.compare(firstNum, secondNum);
    }
}
