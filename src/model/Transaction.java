package model;

import enums.transaction.TransactionType;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private User user;
    private Book book;
    private TransactionType type;
    private LocalDateTime date;

    public Transaction( User user, Book book, TransactionType type, LocalDateTime date) {
        this.user = user;
        this.book = book;
        this.type = type;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
