package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void whenAddThenTrue() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenAddThenFalse() {
        Citizen first = new Citizen("356913", "Alex");
        Citizen second = new Citizen("356913", "Mike");
        PassportOffice office = new PassportOffice();
        office.add(first);
        assertFalse(office.add(second));
    }
}