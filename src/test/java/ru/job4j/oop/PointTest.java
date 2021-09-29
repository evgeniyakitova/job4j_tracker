package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void firstDistance3d() {
        Point a = new Point(2, 3, 4);
        Point b = new Point(0,2,2);
        double expected = 3;
        double result = a.distance3d(b);
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void secondDistance3d() {
        Point a = new Point(5, 3, 10);
        Point b = new Point(2,1,5);
        double expected = 6.16;
        double result = a.distance3d(b);
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void thirdDistance3d() {
        Point a = new Point(2, 0, 1);
        Point b = new Point(0,3,2);
        double expected = 3.74;
        double result = a.distance3d(b);
        assertEquals(expected, result, 0.01);
    }
}