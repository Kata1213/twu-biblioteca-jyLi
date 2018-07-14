package com.twu.biblioteca;

public class Book extends Item {
    private String author;
    private int yearOfPublished;

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublished() {
        return yearOfPublished;
    }

    public Book(String title, String author, int yearOfPublished) {
        super(title, Type.BOOK);
        this.author = author;
        this.yearOfPublished = yearOfPublished;
    }

}
