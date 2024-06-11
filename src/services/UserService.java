package services;

import model.User;

public interface UserService {
    User saveUser(User user);
    User login(String email, String password);
}
