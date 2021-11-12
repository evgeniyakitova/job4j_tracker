package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public int multiply(int a) {
        return x * a;
    }

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int sum = Calculator.sum(10);
        int min = Calculator.minus(7);
        Calculator calc = new Calculator();
        int mult = calc.multiply(4);
        int div = calc.divide(7);
        int sumAll = calc.sumAllOperation(6);
        System.out.println(sum + " " + min + " " + mult + " " + div + " " + sumAll);
    }
}
