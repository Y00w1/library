package util;

import util.command.factory.CommandFactory;
import controller.BookController;
import controller.TransactionController;
import controller.UserController;
import repository.BookRepository;
import repository.TransactionRepository;
import repository.UserRepository;
import repository.imp.BookRepositoryImp;
import repository.imp.TransactionRepositoryImp;
import repository.imp.UserRepositoryImp;
import services.BookService;
import services.TransactionService;
import services.UserService;
import services.imp.BookServiceImp;
import services.imp.TransactionServiceImp;
import services.imp.UserServiceImp;
import view.BookView;
import view.LibraryView;
import view.TransactionView;
import view.UserView;

import java.util.Scanner;

public class DependencyInjector {

    //Repositories
    private static final UserRepository userRepository = new UserRepositoryImp();
    private static final BookRepository bookRepository = new BookRepositoryImp();
    private static final TransactionRepository transactionRepository = new TransactionRepositoryImp();

    //Transaction Commands
    private static final CommandFactory commandFactory = new CommandFactory(transactionRepository);

    //Services
    private static final UserService userService = new UserServiceImp(userRepository);
    private static final BookService bookService = new BookServiceImp(bookRepository);
    private static final TransactionService transactionService = new TransactionServiceImp(commandFactory);

    private final LibraryView libraryView = new LibraryView();

    // Controllers
    private final UserController userController;
    private final TransactionController transactionController;
    private final BookController bookController;

    public DependencyInjector(Scanner scanner) {
        /// Views
        UserView userView = new UserView(scanner);
        BookView bookView = new BookView(scanner);
        TransactionView transactionView = new TransactionView(scanner, bookView);

        this.userController = new UserController(userService, userView);
        this.transactionController = new TransactionController(transactionService, bookService, transactionView);
        this.bookController = new BookController(bookService, bookView);
    }

    public UserController getUserController() {
        return userController;
    }

    public BookController getBookController() {
        return bookController;
    }

    public TransactionController getTransactionController() {
        return transactionController;
    }

    public LibraryView getLibraryView() {
        return libraryView;
    }

    public UserService getUserService() {
        return userService;
    }

    public BookService getBookService() {
        return bookService;
    }

}
