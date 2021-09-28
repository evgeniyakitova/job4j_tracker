package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic example = new DummyDic();
        String word =  example.engToRus("cat");
        System.out.println(word);

    }
}
