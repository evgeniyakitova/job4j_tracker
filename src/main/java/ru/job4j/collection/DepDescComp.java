package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        String first = s1.split("/")[0];
        String second = s2.split("/")[0];
        int rsl = second.compareTo(first);
        if (rsl == 0) {
            return s1.compareTo(s2);
        }
        return rsl;
    }
}
