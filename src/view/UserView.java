package view;

import model.User;

import java.util.Scanner;

public class UserView {
    private final Scanner scanner;

    public UserView(Scanner scanner) {
        this.scanner = scanner;
    }

    public User promptRegister(){
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        return new User(name, email, password); //Change it to DTOs
    }

    public User promptLogin(){
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        return new User(email, password); //Change it to DTOs
    }
}
