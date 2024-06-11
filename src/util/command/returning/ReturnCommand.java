package util.command.returning;

import constraints.TransactionConstraint;
import util.command.Command;
import model.Transaction;
import repository.TransactionRepository;

public class ReturnCommand implements Command {
    private final TransactionConstraint transactionConstraint;
    private final TransactionRepository transactionRepository;

    public ReturnCommand(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionConstraint = new TransactionConstraint(transactionRepository);
    }

    @Override
    public void execute(Transaction transaction) {
        if (!transactionConstraint.isTransactionExistByBookAndUser(transaction.getBook(), transaction.getUser())) {
            System.out.println("Transaction does not exist");
            return;
        }
        if (!transactionConstraint.isBookBorrowed(transaction)){
            System.out.println("Book is not borrowed");
            return;
        }
        Transaction transactionToReturn = transactionRepository.getTransactionByBookAndUser(transaction.getBook(), transaction.getUser()).get();
        transactionToReturn.getBook().setAvailable(true);
        transactionToReturn.getUser().getBorrowedBooks().remove(transaction.getBook().getId());
        transactionRepository.removeTransaction(transactionToReturn);
    }
}
