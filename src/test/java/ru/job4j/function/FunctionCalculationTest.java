package ru.job4j.function;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionCalculationTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCalculation.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = List.of(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = FunctionCalculation.diapason(1, 4, x -> 10 * x * x + 5 * x + 1);
        List<Double> expected = List.of(16D, 51D, 106D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        List<Double> result = FunctionCalculation.diapason(2, 5, x -> Math.pow(2, x));
        List<Double> expected = List.of(4D, 8D, 16D);
        assertThat(result, is(expected));
    }
}