package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void when12And55Then5() {
        Point a = new Point(1, 2);
        Point b = new Point(5, 5);
        double expected = 5;
        double result = a.distance(b);
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void when27And51Then6Dot7() {
        Point a = new Point(2, 7);
        Point b = new Point(5, 1);
        double expected = 6.7;
        double result = a.distance(b);
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void when234And022Then3() {
        Point a = new Point(2, 3, 4);
        Point b = new Point(0, 2, 2);
        double expected = 3;
        double result = a.distance3d(b);
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void when5310And215Then6Dot16() {
        Point a = new Point(5, 3, 10);
        Point b = new Point(2, 1, 5);
        double expected = 6.16;
        double result = a.distance3d(b);
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void when201And032Then3Dot74() {
        Point a = new Point(2, 0, 1);
        Point b = new Point(0, 3, 2);
        double expected = 3.74;
        double result = a.distance3d(b);
        assertEquals(expected, result, 0.01);
    }
}