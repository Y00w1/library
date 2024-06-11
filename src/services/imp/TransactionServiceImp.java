package services.imp;

import util.command.Command;
import util.command.factory.CommandFactory;
import model.Transaction;
import services.TransactionService;

public class TransactionServiceImp implements TransactionService {
    private CommandFactory commandFactory;

    public TransactionServiceImp(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @Override
    public void performTransaction(Transaction transaction) {
        Command command = commandFactory.createCommand(transaction.getType());
        command.execute(transaction);
    }
}
