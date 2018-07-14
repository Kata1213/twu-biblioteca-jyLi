package com.twu.biblioteca;

public class Movie extends Item {
    private String director;
    private int year;
    private Integer rating;

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public Integer getRating() {
        return rating;
    }

    public Movie(String title, String director, int year, Integer rating) {
        super(title, Type.MOVIE);
        this.director = director;
        this.year = year;
        this.rating = rating;

    }

}
