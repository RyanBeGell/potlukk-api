package dev.team2.services;

import dev.team2.entities.User;
import dev.team2.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.Optional;

@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User registerUser(User user) {
        Optional<User> possibleUser = userRepo.findById(user.getUsername());
        if(possibleUser.isPresent()){
            throw new DataIntegrityViolationException("Username + " +user.getUsername() + "is not unique.");
        }
        else return this.userRepo.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        Optional<User> possibleUser = userRepo.findById(username);
        if(possibleUser.isPresent()){
            return possibleUser.get();
        }else{
            throw new EntityNotFoundException("User: " + username + " not found"); // change
        }
    }
}




