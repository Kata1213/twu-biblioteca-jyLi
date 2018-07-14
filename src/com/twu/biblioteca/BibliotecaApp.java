
        package com.twu.biblioteca;

import com.twu.biblioteca.App;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.ItemList;

import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
        ItemList list = new ItemList();
        list.getList().addAll(Arrays.asList(
                new Book("Book1", "Author1", 2015),
                new Book("Book2", "Author1", 2016),
                new Book("Book3", "Author2", 2017),
                new Book("Book4", "Author3", 2018)));

        list.getList().addAll(Arrays.asList(
                new Movie("Movie1", "Director1", 2004, null),
                new Movie("Movie2", "Director2", 2004, 10),
                new Movie("Movie3", "Director2", 2004, 5)));
        App app = new App(list);
        app.run();
    }
}
