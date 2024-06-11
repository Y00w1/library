package repository.imp;

import model.Book;
import model.Transaction;
import model.User;
import repository.TransactionRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TransactionRepositoryImp implements TransactionRepository {
    private final Map<Integer, Transaction> transactions = new HashMap<>();

    @Override
    public void addTransaction(Transaction transaction) {
        transaction.setId(transactions.size()+1);
        transactions.put(transaction.getId(), transaction);
    }

    @Override
    public Transaction getTransactionById(int id) {
        return transactions.get(id);
    }

    @Override
    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction.getId());
    }

    @Override
    public Optional<Transaction> getTransactionByBookAndUser(Book book, User user) {
        for (Transaction transaction : transactions.values()) {
            if (transaction.getBook().equals(book) && transaction.getUser().equals(user)) {
                return Optional.of(transaction);
            }
        }
        return Optional.empty();
    }

}
