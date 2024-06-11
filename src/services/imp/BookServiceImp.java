package services.imp;

import model.Book;
import repository.BookRepository;
import services.BookService;

import java.util.List;

public class BookServiceImp implements BookService {
    private BookRepository bookRepository;

    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.saveBook(book);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public List<Book> getAvailableBooks() {
        return bookRepository.getAvailableBooks();
    }
}
