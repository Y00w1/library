package view;

import model.Book;

import java.util.Scanner;

public class TransactionView {
    private final BookView bookView;
    private final Scanner scanner;

    public TransactionView(Scanner scanner, BookView bookView) {
        this.scanner = scanner;
        this.bookView = bookView;
    }

    public int loanBook() {
        System.out.println("Enter the book ID you want to loan (or enter 0 to cancel):");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (bookId == 0) {
            System.out.println("Loan canceled.");
            return -1;
        }
        return bookId;
    }

    public int returnBook() {
        System.out.println("Enter the book ID you want to return (or enter 0 to cancel):");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (bookId == 0) {
            System.out.println("Return canceled.");
            return 0; // Exit the method
        }
        return bookId;
    }

    public void showLoanSuccess(Book book) {
        System.out.println("Book loaned successfully!");
        bookView.displayBookDetails(book);
    }
    public void showReturnSuccess(Book book) {
        System.out.println("Book returned successfully!");
        bookView.displayBookDetails(book);
    }
}
