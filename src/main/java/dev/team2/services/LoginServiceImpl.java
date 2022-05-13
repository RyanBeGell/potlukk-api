package dev.team2.services;
import dev.team2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    UserService userService;

    @Override
    public User login(String username, String password) {
            User user = userService.findUserByUsername(username);
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new RuntimeException("Invalid credentials.");
            }
    }
}
