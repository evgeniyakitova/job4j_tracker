package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenAscByAge() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Viktor", 56));
        users.add(new User("Viktor", 54));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Viktor", 54)));
        assertThat(it.next(), is(new User("Viktor", 56)));
    }

    @Test
    public void whenAscByName() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Evgeniya", 30));
        users.add(new User("Evgeniy", 35));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Evgeniy", 35)));
        assertThat(it.next(), is(new User("Evgeniya", 30)));
    }
}