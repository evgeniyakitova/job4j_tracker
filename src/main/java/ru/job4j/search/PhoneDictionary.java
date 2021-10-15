package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(key) || person.getPhone().contains(key)
                    || person.getAddress().contains(key) || person.getSurname().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
