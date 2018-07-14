package com.twu.biblioteca;

public class Book {
    private final String author;
    private final String title;
    private final int publishYear;


            Book(String title, String author,int publishYear) {
                this.title = title;
                this.author = author;
                this.publishYear = publishYear;
            }

            @Override
    public String toString() {
                return String.format("%-20s %-20s %-20s", title, author, publishYear);
            }


        }