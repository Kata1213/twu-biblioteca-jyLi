package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Menu {
    private Scanner scanner;
    private List<MenuItem> items = new ArrayList<MenuItem>();
    Menu(Scanner scanner) {
                this.scanner = scanner;
            }

            void add(MenuItem item) {
                items.add(item);
            }

            void run() {
                boolean running = true;
                while (running){
                        show();
                        int num = scanner.nextInt();
                        running = select(num);
                    }
            }

            boolean select(int index) {
                if (index - 1 == items.size()) {
                        return false;
                    }
                if (index - 1 > items.size() || index - 1 < 0) {
                        System.out.println("Select a valid option!");
                        return true;
                    }
                items.get(index - 1).run();
                return true;
            }


            private void show() {
                System.out.println("The library menu:");
                int index = 0;
                for (MenuItem item : items) {
                        System.out.printf("%d.%s\n", ++index, item.getTitle());

                            }
               System.out.printf("%d.%s\n", items.size() + 1, "Quit");
                System.out.print("Input a number: "); }

        }
