package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void maxWhenTwo() {
        int first = 7;
        int second = 17;
        int expected = 17;
        Max calc = new Max();
        int result = calc.max(first, second);
        assertEquals(expected, result);
    }

    @Test
    public void maxWhenThree() {
        int first = 5;
        int second = 10;
        int third = 4;
        int expected = 10;
        Max calc = new Max();
        int result = calc.max(first, second, third);
        assertEquals(expected, result);
    }

    @Test
    public void maxWhenFour() {
        int first = 5;
        int second = 10;
        int third = 4;
        int fourth = 35;
        int expected = 35;
        Max calc = new Max();
        int result = calc.max(first, second, third, fourth);
        assertEquals(expected, result);
    }
}