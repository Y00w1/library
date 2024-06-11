package repository;

import model.Book;
import model.Transaction;
import model.User;

import java.util.Optional;

public interface TransactionRepository {
    void addTransaction(Transaction transaction);
    Transaction getTransactionById(int id);
    void removeTransaction(Transaction transaction);//TODO: change the transaction status
    Optional<Transaction> getTransactionByBookAndUser(Book book, User user); //TODO: change the transaction ID in order to be the user and book id combined
}
