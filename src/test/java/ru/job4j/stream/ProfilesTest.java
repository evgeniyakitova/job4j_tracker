package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollectTwoAddress() {
        Profiles profiles = new Profiles();
        List<Address> result = profiles.collect(Arrays.asList(
                new Profile(new Address("Moscow", "Tverskaya", 23, 3)),
                new Profile(new Address("Moscow", "Vavilova", 33, 3))
        ));
        List<Address> expected = List.of(
                new Address("Moscow", "Tverskaya", 23, 3),
                new Address("Moscow", "Vavilova", 33, 3)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenCollectFourAddressThenTwo() {
        Profiles profiles = new Profiles();
        List<Address> result = profiles.collect(Arrays.asList(
                new Profile(new Address("Moscow", "Vavilova", 33, 3)),
                new Profile(new Address("Moscow", "Vavilova", 33, 3)),
                new Profile(new Address("Chelyabinsk", "Frunze", 23, 3)),
                new Profile(new Address("Chelyabinsk", "Frunze", 23, 3))
        ));
        List<Address> expected = List.of(
                new Address("Chelyabinsk", "Frunze", 23, 3),
                new Address("Moscow", "Vavilova", 33, 3)
        );
        assertThat(result, is(expected));
    }
}