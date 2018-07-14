package com.twu.biblioteca;

import java.util.Scanner;

public class App {
    private BookList list;

    App() {
        this.list = new BookList();
    }

    App(BookList list) {
        this.list = list;
    }

    public void run() {
        System.out.println(welcome());
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        while (!quit){
            System.out.println(mainMenu());
            int command = sc.nextInt();
            switch (command){
                default:
                    System.out.println("Select a valid option!");
                    break;
                case 1:
                    System.out.println(listAllBooks());
                    break;
                case 2:
                    System.out.println("Input The Book Title You Want To Checkout:");
                    String titleC = sc.next();
                    System.out.println(checkoutBook(titleC));
                    break;
                case 3:
                    System.out.println("Input The Book Title You Want To Return:");
                    String titleR = sc.next();
                    System.out.println(returnBook(titleR));
                    break;
                case 4:
                    quit = true;
                    System.out.println("Bye Bye!");
                    break;
            }
        }
    }

    public String welcome() {
        return "WELCOME TO BIBLIOTECA SYSTEM!";
    }

    public String mainMenu() {
        return "1. List Books\n" + "2. Checkout Book\n" + "3. Return Book\n" + "4. Quit";
    }

    public String listAllBooks() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.list.getList().size(); ++i) {
            Book book = this.list.getList().get(i);
            String current = (i+1) + ".\t"
                    + book.getTitle() + "\t"
                    + book.getAuthor() + "\t"
                    + book.getYearOfPublished() + "\t["
                    + (book.getIsCheckedOut()? "": "Not") + "CheckedOut]\n";
            result.append(current);
        }
        return result.toString();
    }

    public String checkoutBook(String title) {
        Book book = this.list.findBookByName(title);
        if (book != null && book.checkOutBook()){
            return "Thank you! Enjoy the book.";
        }
        else{
            return "That book is not available.";
        }
    }

    public String returnBook(String title) {
        Book book = this.list.findBookByName(title);
        if (book != null && book.returnBook()){
            return "Thank you for returning the book.";
        }
        else{
            return "That is not a valid book to return.";
        }
    }
}