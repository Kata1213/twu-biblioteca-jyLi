package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookTest {
    private Book book;

    @Before
    public void setUp() throws Exception {
        this.book = new Book("Book1", "Author1", 2000);
    }

    @Test
    public void testCheckoutBookShouldReturnCorrectResult() {
        assertThat(true, is(this.book.checkOutItem()));
        assertThat(false, is(this.book.checkOutItem()));
    }

    @Test
    public void testReturnBookShouldReturnCorrectResult() {
        assertThat(false, is(this.book.returnItem()));
        this.book.checkOutItem();
        assertThat(true, is(this.book.returnItem()));
    }
}