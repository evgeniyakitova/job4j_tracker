package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenNotFind() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "555444", "Bryansk")
        );
        var persons = phones.find("Elena");
        assertThat(persons.size(), is(0));
    }
}