package dev.team2.services;

import dev.team2.entities.User;

import java.util.List;

public interface UserService {

    User registerUser (User user);
    List<User> getAllUsers();

    User getUserByUsername(String username);



}
