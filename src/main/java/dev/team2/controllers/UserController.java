package dev.team2.controllers;

import dev.team2.entities.User;
import dev.team2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {


    @Autowired // will try to find a bean that can be injected here
    private UserService userService;

    @GetMapping("/users") // spring will generate a route /user that when a get is sent there this method will be called
    @ResponseBody // converts the return into a JSON for the HTTP response
    public List<User> retrieveAllUsers(){
        List<User> users = this.userService.getAllUsers();
        return users;
    }

    @GetMapping("/users/{username}") // param in string must match param in method signature
    @ResponseBody
    public User retrieveUserByUsername(@PathVariable String username){
        User user= this.userService.getUserByUsername(username);
        return user;
    }

    @PostMapping("/users")
    @ResponseBody
    public User createUser(@RequestBody User user){ // will convert the JSON request body into an object
        return this.userService.registerUser(user);
    }


}
