package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException() {
        super("This element is not in the array");
    }
}
