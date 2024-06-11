package repository;

import model.User;

public interface UserRepository {
    User saveUser(User user);
    User getUserByEmail(String email);
}
