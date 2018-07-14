package com.twu.biblioteca;
import java.util.List;

class Library {

  private List<Book> availableBooks;

            Library(List<Book> books) {
                this.availableBooks = books;
            }

            void printHeadings() {
                System.out.print(String.format("%-20s %-20s %-20s %n", "Title", "Author", "Year Published"));
            }
    void printBooksList() {
                printHeadings();
                for (Book book : availableBooks) {
                        System.out.println(book);
                    }
            }
}
