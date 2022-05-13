package dev.team2.controllers;

import dev.team2.entities.User;
import dev.team2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class UserController {


    @Autowired // will try to find a bean that can be injected here
    private UserService userService;

    @GetMapping("/users/{username}") // param in string must match param in method signature
    @ResponseBody
    public User retrieveUserByUsername(@PathVariable String username){
        try {
            return this.userService.findUserByUsername(username);
        } catch (EntityNotFoundException e){
            //username not found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username " + username + " not found.");
        }
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){ // will convert the JSON request body into an object
        try {
            return this.userService.registerUser(user);
        } catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username + " + user.getUsername()
                    + "is already taken.");
        }
    }
}
