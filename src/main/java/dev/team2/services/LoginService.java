package dev.team2.services;

import dev.team2.entities.User;

public interface LoginService {

    User login(String username, String password);
}
