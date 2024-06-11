package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private String email;
    private String password;
    private Map<Integer, Book> borrowedBooks;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.borrowedBooks = new HashMap<>();
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Map<Integer, Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
