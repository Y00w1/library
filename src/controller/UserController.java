package controller;

import model.User;
import services.UserService;
import view.UserView;

public class UserController {
    private final UserService userService;
    private final UserView userView;

    public UserController(UserService userService, UserView userView) {
        this.userService = userService;
        this.userView = userView;
    }

    public User login(){
        User user = userView.promptLogin();
        return userService.login(user.getEmail(), user.getPassword());
    }

    public User register(){
        User user = userView.promptRegister();
        return userService.saveUser(user);
    }
}
