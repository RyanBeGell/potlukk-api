package dev.team2.controllers;

import dev.team2.dtos.LoginInfo;
import dev.team2.dtos.UserInfo;
import dev.team2.entities.User;
import dev.team2.services.LoginService;
import dev.team2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        try {
            return this.userService.registerUser(user);
        } catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username + " + user.getUsername()
                    + "is already taken.");
        }
    }

    @PostMapping("/login")
    UserInfo login(@RequestBody LoginInfo loginInfo){
        try {
            //attempt to log in with the credentials provided
            User user = loginService.login(loginInfo.getUsername(), loginInfo.getPassword());
            //Return the User information (unless exception is not thrown for invalid credentials)
            return new UserInfo(user.getUsername(), user.getFirstName(), user.getLastName());
        } catch (RuntimeException e){
            //exception thrown when trying to log in
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication failed: username or password incorrect.");
        }
    }
}
