package constraints;

import model.User;
import repository.UserRepository;

public class UserConstraint {
    private final UserRepository userRepository;

    public UserConstraint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isEmailAvailable(String email) {
        return userRepository.getUserByEmail(email) != null;
    }
    public boolean isEmailAndPasswordMatch(String email, String password){
        User user = userRepository.getUserByEmail(email);
        return user.getPassword().equals(password);
    }
}
