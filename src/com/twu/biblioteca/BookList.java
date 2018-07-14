package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

        public class BookList {
    private List<Book> list;

            public List<Book> getList() {
                return list;
            }

            public BookList() {

                       this.list = new LinkedList<Book>();
            }
            public Book findBookByName(String name) {
                        return this.list.stream().filter(book -> book.getTitle().equals(name)).findFirst().orElse(null);
                                      }
        }
