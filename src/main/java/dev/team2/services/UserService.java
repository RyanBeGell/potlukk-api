package dev.team2.services;

import dev.team2.entities.User;

public interface UserService {

    User registerUser (User user);

    User findUserByUsername(String username);

    boolean deleteUserByUsername(String username);

}
