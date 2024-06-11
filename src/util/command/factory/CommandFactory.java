package util.command.factory;

import util.command.Command;
import util.command.loan.LoanCommand;
import util.command.returning.ReturnCommand;
import enums.transaction.TransactionType;
import repository.TransactionRepository;

public class CommandFactory {
    private TransactionRepository transactionRepository;

    public CommandFactory(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Command createCommand(TransactionType transactionType){
        return switch (transactionType) {
            case LOAN -> new LoanCommand(transactionRepository);
            case RETURN -> new ReturnCommand(transactionRepository);
        };
    }
}
