package constraints;

import model.Book;
import model.Transaction;
import model.User;
import repository.TransactionRepository;

public class TransactionConstraint {
    private final TransactionRepository transactionRepository;

    public TransactionConstraint(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public boolean isTransactionExist(int id) {
        return transactionRepository.getTransactionById(id) != null;
    }

    public boolean isBookAvailable(Transaction transaction) {
        return transaction.getBook().isAvailable();
    }
    public boolean isBookBorrowed(Transaction transaction) {
        return transaction.getUser().getBorrowedBooks().containsKey(transaction.getBook().getId());
    }

    public boolean isTransactionExistByBookAndUser(Book book, User user) {
        return transactionRepository.getTransactionByBookAndUser(book, user).isPresent();
    }
}
