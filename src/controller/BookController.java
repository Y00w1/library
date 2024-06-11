package controller;

import services.BookService;
import view.BookView;

public class BookController {
    private final BookService bookService;
    private final BookView bookView;

    public BookController(BookService bookService, BookView bookView) {
        this.bookService = bookService;
        this.bookView = bookView;
    }

    public void viewAvailableBooks() {
        bookView.displayAvailableBooks(bookService.getAvailableBooks());
    }

    public void viewMyBorrowedBooks() {
        bookView.displayMyBorrowedBooks();
    }
}
