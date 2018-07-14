package com.twu.biblioteca;

public class Book {
    private final String author;
    private final String title;
    private final int publishYear;

    public String getTitle() {
        return title;
    }

    Book(String title, String author, int publishYear) {
                this.title = title;
                this.author = author;
                this.publishYear = publishYear;
            }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublished() {
        return publishYear;
    }

            @Override
    public String toString() {
                return String.format("%-20s %-20s %-20s", title, author, publishYear);
            }


        }