package com.twu.biblioteca;

import java.util.Scanner;

public class App {
    private ItemList list;
    private User user;

    App(ItemList list) {
        this.list = list;
    }

    public boolean login(String username, String password){
        User user = new User(username, "email@username", 1000, password);
        this.user = user;
        return true;
    }

    public void run() {
        System.out.println(welcome());
        Scanner sc = new Scanner(System.in);
        boolean notlogin = true;
        while (notlogin){
            System.out.println("[LOGIN]Input username:");
            String username = sc.next();
            System.out.println("[LOGIN]Input password:");
            String password = sc.next();
            notlogin = !login(username, password);
        }
        boolean quit = false;
        while (!quit){
            System.out.println(mainMenu());
            int command = sc.nextInt();
            switch (command){
                default:
                    System.out.println("Select a valid option!");
                    break;
                case 1:
                    System.out.println(listAll(Item.Type.BOOK));
                    break;
                case 2:
                    System.out.println(listAll(Item.Type.MOVIE));
                    break;
                case 3:
                    System.out.println("Input The Book Or Movie Title You Want To Checkout:");
                    String titleC = sc.next();
                    System.out.println(checkoutItem(titleC));
                    break;
                case 4:
                    System.out.println("Input The Book Or Movie Title You Want To Return:");
                    String titleR = sc.next();
                    System.out.println(checkoutItem(titleR));
                    break;
                case 5:
                    System.out.println(displayUserInfo());
                    break;
                case 9:
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
        return "1. List Books\n"
                + "2. List Movies\n"
                + "3. Checkout Book Or Movie\n"
                + "4. Return Book Or Movie\n"
                + "5. Display User Information\n"
                + "9. Quit";
    }

    public String displayUserInfo() {
        return this.user.getName() + "\t" + this.user.getEmail() + "\t" + this.user.getPhoneNumber();
    }

    public String listAll(Item.Type type) {
        StringBuilder result = new StringBuilder();
        int index = 1;
        if (type == Item.Type.BOOK) {
            for (int i = 0; i < this.list.getList().size(); ++i) {
                if (this.list.getList().get(i).type == Item.Type.BOOK) {
                    Book book = (Book)this.list.getList().get(i);
                    String current = (index) + ".\t"
                            + book.getTitle() + "\t"
                            + book.getAuthor() + "\t"
                            + book.getYearOfPublished() + "\t["
                            + (book.getIsCheckedOut() ? "" : "Not") + "CheckedOut]\n";
                    result.append(current);
                    index++;
                }
            }
        }
        if (type == Item.Type.MOVIE){
            for (int i = 0; i < this.list.getList().size(); ++i) {
                if (this.list.getList().get(i).type == Item.Type.MOVIE) {
                    Movie movie = (Movie) this.list.getList().get(i);
                    String current = (i + 1) + ".\t"
                            + movie.getTitle() + "\t"
                            + movie.getDirector() + "\t"
                            + movie.getYear() + "\t"
                            + movie.getRating() + "\t["
                            + (movie.getIsCheckedOut() ? "" : "Not") + "CheckedOut]\n";
                    result.append(current);
                    index++;
                }
            }
        }
        return result.toString();
    }

    public String checkoutItem(String title) {
        Item item = this.list.findBookByName(title);
        if (item != null && item.checkOutItem()){
            return "Thank you! Enjoy the book/movie.";
        }
        else{
            return "That book/movie is not available.";
        }
    }

    public String returnItem(String title) {
        Item item = this.list.findBookByName(title);
        if (item != null && item.returnItem()){
            return "Thank you for returning the book/movie.";
        }
        else{
            return "That is not a valid book/movie to return.";
        }
    }
}
