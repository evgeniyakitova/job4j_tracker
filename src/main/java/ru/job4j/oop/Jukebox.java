package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String rsl = "Песня не найдена";
        if (position == 1) {
            rsl = "Пусть бегут неуклюже";
        } else if (position == 2) {
            rsl = "Спокойной ночи";
        }
        System.out.println(rsl);
    }

    public static void main(String[] args) {
        Jukebox singer = new Jukebox();
        singer.music(1);
        singer.music(2);
        singer.music(3);
    }
}
