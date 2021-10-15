package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> peoples = new ArrayList<>();
        peoples.add("Petr");
        peoples.add("Ivan");
        peoples.add("Stepan");
        for (String people : peoples) {
            System.out.println(people);
        }
    }
}
