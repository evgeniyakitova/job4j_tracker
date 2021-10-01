package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("Jane Eyre", 512);
        Book secondBook = new Book("Crime and Punishment", 672);
        Book thirdBook = new Book("War and Peace", 1225);
        Book fourthBook = new Book("Clean code", 1257);
        Book[] books = new Book[] {firstBook, secondBook, thirdBook, fourthBook};
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getTitle() + " - " + book.getPageCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getTitle() + " - " + book.getPageCount());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getTitle().equals("Clean code")) {
                System.out.println(book.getTitle() + " - " + book.getPageCount());
            }
        }
    }
}
