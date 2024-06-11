package util.command.loan;

import constraints.TransactionConstraint;
import services.TransactionService;
import util.command.Command;
import model.Transaction;
import repository.TransactionRepository;

public class LoanCommand implements Command {
    private final TransactionRepository transactionRepository;
    private final TransactionConstraint transactionConstraint;

    public LoanCommand(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionConstraint = new TransactionConstraint(transactionRepository);
    }

    @Override
    public void execute(Transaction transaction) {
        if (transactionConstraint.isTransactionExist(transaction.getId())) {
            System.out.println("Transaction already exist");
            return;
        }
        if (!transactionConstraint.isBookAvailable(transaction)) {
            System.out.println("Book is not available");
            return;
        }
        transaction.getBook().setAvailable(false);
        transaction.getUser().getBorrowedBooks().put(transaction.getBook().getId(), transaction.getBook());
        transactionRepository.addTransaction(transaction);
    }
}
