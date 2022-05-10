package dev.team2.services;




import dev.team2.entities.User;
import dev.team2.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User registerUser(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        List <User> users= this.userRepo.findUsersByUsername(username);
    return ;
    }
    }




