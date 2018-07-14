package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTest {
    private App app;

    @Before
    public void setUp() throws Exception {
        ItemList list = new ItemList();
        list.getList().addAll(Arrays.asList(
                new Book("Book1", "Author1", 2000),
                new Book("Book2", "Author1", 2001),
                new Book("Book3", "Author2", 2002),
                new Book("Book4", "Author3", 2003)));
        list.getList().addAll(Arrays.asList(
                new Movie("Movie1", "Director1", 2004, null),
                new Movie("Movie2", "Director2", 2004, 10),
                new Movie("Movie3", "Director2", 2004, 5)));
        this.app = new App(list);
    }

    @Test
    public void testListAllBooks() {
        String expectStr = "1.\tBook1\tAuthor1\t2000\t[NotCheckedOut]\n" +
                "2.\tBook2\tAuthor1\t2001\t[NotCheckedOut]\n" +
                "3.\tBook3\tAuthor2\t2002\t[NotCheckedOut]\n" +
                "4.\tBook4\tAuthor3\t2003\t[NotCheckedOut]\n";

        String actualStr= this.app.listAll(Item.Type.BOOK);

        assertThat(actualStr, is(expectStr));
    }

    @Test
    public void testWhenCheckoutBookShouldReturnInformation() {
        String expectStr = "Thank you! Enjoy the book/movie.";

        String actualStr = app.checkoutItem("Book1");

        assertThat(actualStr, is(expectStr));
    }

    @Test
    public void testWHenCheckoutNotBookShouldReturnErrorInformation() {
        String expectStr = "That book/movie is not available.";

        String actualStr1 = app.checkoutItem("Book5");
        app.checkoutItem("Book1");
        String actualStr2 = app.checkoutItem("Book1");

        assertThat(actualStr1, is(expectStr));
        assertThat(actualStr2, is(expectStr));
    }

    @Test
    public void testWhenReturnBookShouldReturnInformation() {
        String expectStr = "Thank you for returning the book/movie.";

        app.checkoutItem("Book1");
        String actualStr = app.returnItem("Book1");

        assertThat(actualStr, is(expectStr));
    }

    @Test
    public void testWhenReturnWrongBookShouldReturnErrorInformation() {
        String expectStr = "That is not a valid book/movie to return.";

        String actualStr1 = app.returnItem("Book1");
        String actualStr2 = app.returnItem("Book5");

        assertThat(actualStr1, is(expectStr));
        assertThat(actualStr2, is(expectStr));
    }
}