package services;

import model.Book;

import java.util.List;

public interface BookService {
    void saveBook(Book book);
    Book getBookById(int id);
    List<Book> getAvailableBooks();
}
