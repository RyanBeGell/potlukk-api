package dev.team2.Potlukk.servicetests;

import dev.team2.entities.User;
import dev.team2.services.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //
public class UserServiceTests {

    @Autowired
    public UserService userService;

    private static User testUser = null;

    @Test
    @Order(1)
    public void createUserWithUniqueId() {
        User user = new User("Timmy152","Timmy","Tester","Password123");
        UserServiceTests.testUser = userService.registerUser(user);
        Assertions.assertEquals("Timmy152", testUser.getUsername());
    }

    @Test
    @Order(2)
    public void createUserWithNonUniqueId() {
        User user = new User("Timmy152","Timmy","Tester","Password123");
        Assertions.assertThrows(DataIntegrityViolationException.class, () ->
                UserServiceTests.testUser = userService.registerUser(user));
    }

    @Test
    @Order(3)
    public void findExistingUserByUsername(){
        User user = userService.findUserByUsername(testUser.getUsername());
        Assertions.assertEquals(testUser.getUsername(), user.getUsername());
    }

    @Test
    @Order(3)
    public void findNonExistentUserByUsername(){
        Assertions.assertThrows(EntityNotFoundException.class, () ->
                userService.findUserByUsername("ThisUserDoesNotExist"));
    }

    @Test
    @Order(3)
    public void deleteUser(){
        Assertions.assertTrue(userService.deleteUserByUsername(testUser.getUsername()));
    }

}
