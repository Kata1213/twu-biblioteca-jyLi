package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookGenerator {
    static List<Book> generateBooks() {
                List<Book> books = new ArrayList<Book>();
                books.add(new Book("Clean Code", "Robert C. Martin", 2009));
                books.add(new Book("The Agile Samurai", "Jonathan Rasmusson", 2010));
                books.add(new Book("Core Java", "Horstmann", 2016));
                return books;
            }
}
