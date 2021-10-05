package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Транспорт отправляется");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров: " + count);
    }

    @Override
    public double fuel(double quantity) {
        int price = 60;
        return price * quantity;
    }
}
