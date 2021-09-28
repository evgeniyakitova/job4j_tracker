package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println("Cat " + this.name + " ate " + this.food);
    }

    public void eat(String meal) {
        this.food = meal;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Barsik");
        gav.show();
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Musya");
        black.show();
    }
}
