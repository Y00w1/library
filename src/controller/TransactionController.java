package controller;

import enums.transaction.TransactionType;
import model.Book;
import model.Transaction;
import services.BookService;
import services.TransactionService;
import session.UserSession;
import view.LibraryView;
import view.TransactionView;

import java.time.LocalDateTime;

public class TransactionController {
    private final TransactionService transactionService;
    private final BookService bookService;
    private final TransactionView transactionView;

    public TransactionController(TransactionService transactionService, BookService bookService,
                                 TransactionView transactionView) {
        this.transactionService = transactionService;
        this.bookService = bookService;
        this.transactionView = transactionView;
    }

    public void loanBook() {
        int bookId = transactionView.loanBook();
        if (bookId == -1) {
            return;
        }
        Book book = bookService.getBookById(bookId);
        transactionService.performTransaction(new Transaction(UserSession.getInstance().getLoggedInUser(), book,
                TransactionType.LOAN, LocalDateTime.now()));
        transactionView.showLoanSuccess(book);
    }

    public void returnBook() {
        int bookId = transactionView.returnBook();
        Book book = bookService.getBookById(bookId);
        transactionService.performTransaction(new Transaction(UserSession.getInstance().getLoggedInUser(), book,
                TransactionType.RETURN, LocalDateTime.now()));
        transactionView.showReturnSuccess(book);
    }
}
