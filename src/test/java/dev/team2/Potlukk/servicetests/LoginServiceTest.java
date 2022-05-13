package dev.team2.Potlukk.servicetests;

import dev.team2.entities.User;
import dev.team2.services.LoginService;
import dev.team2.services.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginServiceTest {

    @Autowired
    public LoginService loginService;

    //to create a test user
    @Autowired
    public UserService userService;

    private static User testUser = null;
    private static User loggedInUser= null;

    @Test
    @Order(1)
    public void login_with_correct_credentials(){
        User user = new User("Timmy153","Timmy","Tester","Password1234");
        LoginServiceTest.testUser = userService.registerUser(user);
        LoginServiceTest.loggedInUser = loginService.login(testUser.getUsername(), testUser.getPassword());
        userService.deleteUserByUsername(testUser.getUsername()); //delete our test user from the db
        Assertions.assertEquals(loggedInUser.getUsername(), testUser.getUsername());

    }

    @Test
    @Order(2)
    public void login_with_incorrect_credentials(){
        Assertions.assertThrows(RuntimeException.class,()->
                loginService.login("FakeTestUser", "NotARealPassword"));
    }
}