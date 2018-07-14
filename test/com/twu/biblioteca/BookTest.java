package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class BookTest {
    Book book;

            @Before
    public void setUp() throws Exception {
                book = new Book("title", "author", 2018);
            }

            @Test
    public void should_print_book_detail() {
                assertThat(book.toString(), is(String.format("%-20s %-20s %-20s", "title", "author", "2018")));
            }
}
