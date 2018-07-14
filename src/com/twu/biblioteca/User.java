package com.twu.biblioteca;

public class User {
    private String name;
    private String email;
    private int phoneNumber;
    private String password;

    public User(String name, String email, int phoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
