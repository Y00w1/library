package view;

import model.Book;
import session.UserSession;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookView {
    private final Scanner scanner;

    public BookView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayAvailableBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available!");
        } else {
            System.out.println("Available books:");
            System.out.printf("%-5s | %-30s | %-20s | %-10s%n", "ID", "Title", "Author", "Genre");
            System.out.println("-------------------------------------------------------------");
            for (Book book : books) {
                System.out.printf("%-5d | %-30s | %-20s | %-10s%n",
                        book.getId(), book.getTitle(), book.getAuthor(), book.getGenre());
            }
        }
    }

    public void displayMyBorrowedBooks() {
        Map<Integer, Book> borrowedBooksMap = UserSession.getInstance().getLoggedInUser().getBorrowedBooks();
        if (borrowedBooksMap.isEmpty()) {
            System.out.println("You have not borrowed any books!");
        } else {
            System.out.println("Your borrowed books:");
            System.out.printf("%-5s | %-30s | %-20s | %-10s%n", "ID", "Title", "Author", "Genre");
            System.out.println("-------------------------------------------------------------");
            for (Map.Entry<Integer, Book> entry : borrowedBooksMap.entrySet()) {
                Book book = entry.getValue();
                System.out.printf("%-5d | %-30s | %-20s | %-10s%n",
                        book.getId(), book.getTitle(), book.getAuthor(), book.getGenre());
            }
        }
    }
    public void displayBookDetails(Book book) {
        System.out.println("Book:");
        System.out.println("-------------------------------------------------------------");
        System.out.println("ID: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Genre: " + book.getGenre());
    }
}
