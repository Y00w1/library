package repository.imp;

import model.Book;
import repository.BookRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepositoryImp implements BookRepository {
    private final Map<Integer, Book> books = new HashMap<>();

    @Override
    public void saveBook(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public Book getBookById(int id) {
        return books.get(id);
    }

    @Override
    public List<Book> getAvailableBooks() {
        return books.values().stream().filter(Book::isAvailable).toList();
    }
}
