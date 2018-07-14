package com.twu.biblioteca;

import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookList list = new BookList();
        list.getList().addAll(Arrays.asList(
                new Book("Book1", "Author1", 2015),
                new Book("Book2", "Author1", 2016),
                new Book("Book3", "Author2", 2017),
                new Book("Book4", "Author3", 2018)));
        App app = new App(list);
        app.run();
    }
}