package util.command;

import model.Transaction;

public interface Command {
    void execute(Transaction transaction);
}
