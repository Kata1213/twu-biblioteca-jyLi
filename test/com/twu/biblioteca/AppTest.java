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
        BookList list = new BookList();
        list.getList().addAll(Arrays.asList(
                new Book("Book1", "Author1", 2015),
                new Book("Book2", "Author1", 2016),
                new Book("Book3", "Author2", 2017),
                new Book("Book4", "Author3", 2018)));
        this.app = new App(list);
    }

    @Test
    public void testListAllBooks() {
        String expectStr = "1.\tBook1\tAuthor1\t2000\t[NotCheckedOut]\n" +
                "2.\tBook2\tAuthor1\t2001\t[NotCheckedOut]\n" +
                "3.\tBook3\tAuthor2\t2002\t[NotCheckedOut]\n" +
                "4.\tBook4\tAuthor3\t2003\t[NotCheckedOut]\n";

        String actualStr= this.app.listAllBooks();

        assertThat(actualStr, is(expectStr));
    }

    @Test
    public void testWhenCheckoutBookShouldReturnInformation() {
        String expectStr = "Thank you! Enjoy the book.";

        String actualStr = app.checkoutBook("Book1");

        assertThat(actualStr, is(expectStr));
    }

    @Test
    public void testWHenCheckoutNotBookShouldReturnErrorInformation() {
        String expectStr = "That book is not available.";

        String actualStr1 = app.checkoutBook("Book5");
        app.checkoutBook("Book1");
        String actualStr2 = app.checkoutBook("Book1");

        assertThat(actualStr1, is(expectStr));
        assertThat(actualStr2, is(expectStr));
    }

    @Test
    public void testWhenReturnBookShouldReturnInformation() {
        String expectStr = "Thank you for returning the book.";

        app.checkoutBook("Book1");
        String actualStr = app.returnBook("Book1");

        assertThat(actualStr, is(expectStr));
    }

    @Test
    public void testWhenReturnWrongBookShouldReturnErrorInformation() {
        String expectStr = "That is not a valid book to return.";

        String actualStr1 = app.returnBook("Book1");
        String actualStr2 = app.returnBook("Book5");

        assertThat(actualStr1, is(expectStr));
        assertThat(actualStr2, is(expectStr));
    }
}