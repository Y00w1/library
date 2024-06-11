package repository;

import model.Book;

import java.util.List;

public interface BookRepository {
    void saveBook(Book book);

    Book getBookById(int id);

    List<Book> getAvailableBooks();
}
