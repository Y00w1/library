package repository.imp;

import model.User;
import repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImp implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public User saveUser(User user) {
        users.put(user.getEmail(), user);
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        return users.get(email);
    }
}
