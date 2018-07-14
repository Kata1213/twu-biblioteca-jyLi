package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookListTest {
    private BookList list;

    @Before
    public void setUp() throws Exception {
        this.list = new BookList();

        this.list.getList().addAll(Arrays.asList(
                new Book("Book1", "Author1", 2000),
                new Book("Book2", "Author1", 2001),
                new Book("Book3", "Author2", 2002),
                new Book("Book4", "Author3", 2003)));
    }

    @Test
    public void testWhenGetListShouldReturnCorrectBookList() {
        int expectNum = 4;
        int actualNum = this.list.getList().size();

        assertThat(actualNum, is(expectNum));
    }

    @Test
    public void testWhenInputCorrectTitleShouldGetCorrectBook() {
        String expectAuthor = "Author1";
        int expectYear = 2001;

        Book actualBook = this.list.findBookByName("Book2");
        String actualAuthor = actualBook.getAuthor();
        int acutalYear = actualBook.getYearOfPublished();

        assertThat(actualAuthor, is(expectAuthor));
        assertThat(acutalYear, is(expectYear));
    }
}
