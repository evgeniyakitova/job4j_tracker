package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MatrixConversionTest {

    @Test
    public void whenConvertMatrixToList() {
        Integer[][] in = {{3, 4, 5}, {1, 2, 3}, {6, 7, 8}};
        List<Integer> rsl = MatrixConversion.convertToList(in);
        List<Integer> expected = List.of(3, 4, 5, 1, 2, 3, 6, 7, 8);
        assertEquals(rsl, expected);
    }
}