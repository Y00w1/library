/*Una biblioteca necesita un sistema de gestión para administrar su colección de libros,
los usuarios que toman prestados los libros y el proceso de préstamo y devolución de libros.
El sistema debe ser capaz de manejar múltiples usuarios, libros y transacciones de préstamo/devolución,
generar una solución y aplicar los principios SOLID
 */

import controller.BookController;
import controller.TransactionController;
import controller.UserController;
import enums.book.Genre;
import model.Book;
import model.User;
import services.BookService;
import services.UserService;
import session.UserSession;
import util.DependencyInjector;
import view.LibraryView;

import java.util.Scanner;

public class Library {
    private static final Scanner scanner = new Scanner(System.in);

    private static final DependencyInjector injector = new DependencyInjector(scanner);

    private static final UserController userController = injector.getUserController();
    private static final BookController bookController = injector.getBookController();
    private static final TransactionController transactionController = injector.getTransactionController();
    private static final LibraryView libraryView = injector.getLibraryView();

    public static void main(String[] args) {
        addDummyData();

        while (true) {
            libraryView.showLoginMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (login()) {
                        mainMenu();
                    }
                    break;
                case 2:
                    if (register()) {
                        mainMenu();
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }


    }

    private static boolean login(){
        User user = userController.login();
        if (user != null) {
            UserSession.getInstance().setLoggedInUser(user);
            return true;
        }
        return false;
    }

    private static boolean register(){
        User user = userController.register();
        if (user != null) {
            UserSession.getInstance().setLoggedInUser(user);
            return true;
        }
        return false;
    }

    private static void mainMenu() {
        while (true) {
            libraryView.showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    transactionController.loanBook();
                    break;
                case 2:
                    transactionController.returnBook();
                    break;
                case 3:
                    bookController.viewAvailableBooks();
                    break;
                case 4:
                    bookController.viewMyBorrowedBooks();
                    break;
                case 5:
                    UserSession.getInstance().setLoggedInUser(null);
                    return;
                case 6:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }


    private static void addDummyData(){
        UserService userService = injector.getUserService();
        BookService bookService = injector.getBookService();

        //Add dummy users
        userService.saveUser(new User("John", "jhon@mail.com", "admin123"));
        userService.saveUser(new User("Doe", "doe", "pas"));

        //Add dummy books
        bookService.saveBook(new Book(1, "Book 1", "Author 1", Genre.TRAGEDY, 2008));
        bookService.saveBook(new Book(2, "Book 2", "Author 2", Genre.COMEDY, 2009));
        bookService.saveBook(new Book(3, "Book 3", "Author 3", Genre.FICTION, 2010));
    }
}