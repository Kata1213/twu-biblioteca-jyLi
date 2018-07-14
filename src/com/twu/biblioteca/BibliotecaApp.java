package com.twu.biblioteca;

import java.util.Scanner;
public class BibliotecaApp {
         public static void main(String[] args) {
               Scanner scanner = new Scanner(System.in);
               printWelcome();
                Library library = new Library(BookGenerator.generateBooks());
                Menu menu = new Menu(scanner);
                generateMenu(menu,library);
                menu.run();

                    }

            private static void printWelcome() {
                System.out.println("Welcome to the Bangalore Public Library!");
            }

            private static void generateMenu(Menu menu, final Library library) {
                MenuItem listBook = new MenuItem("List Books", new Runnable() {
            @Override
            public void run() {
                               library.printBooksList();
                           }
       });
                menu.add(listBook);
            }
}