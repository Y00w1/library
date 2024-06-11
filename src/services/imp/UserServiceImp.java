package services.imp;

import constraints.UserConstraint;
import model.User;
import repository.UserRepository;
import services.UserService;

public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserConstraint userConstraint;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userConstraint = new UserConstraint(this.userRepository);
    }

    @Override
    public User saveUser(User user) {
        if (userConstraint.isEmailAvailable(user.getEmail())){
            System.out.println("Email is already taken");
            return null;
        }
        return userRepository.saveUser(user);
    }

    @Override
    public User login(String email, String password) {
        if (!userConstraint.isEmailAndPasswordMatch(email, password)){
            System.out.println("Login failed");
            return null;
        }
        System.out.println("Login successful");
        return userRepository.getUserByEmail(email);
    }
}
