package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class DepDescCompTest {

    @Test
    public void whenUpDepartmentGoAfter() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescSortAll() {
        List<String> input = Arrays.asList("K1/SK1/SSK1", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K1/SK1/SSK2", "K1/SK1", "K2/SK1", "K2", "K1/SK2", "K1");
        List<String> expected = Arrays.asList("K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2");
        Departments.sortDesc(input);
        assertThat(input, is(expected));
    }

}