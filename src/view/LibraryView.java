package view;


public class LibraryView {

    public void showLoginMenu(){
        System.out.println("Welcome to the Library System!");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Please choose an option: ");
    }

    public void showMainMenu(){
        System.out.println("Main Menu:");
        System.out.println("1. Borrow a book");
        System.out.println("2. Return a book");
        System.out.println("3. View available books");
        System.out.println("4. View my borrowed books");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
        System.out.print("Please choose an option: ");
    }
}
