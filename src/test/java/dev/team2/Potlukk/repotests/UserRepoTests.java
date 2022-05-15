package dev.team2.Potlukk.repotests;


import dev.team2.entities.User;
import dev.team2.repos.UserRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

@SpringBootTest

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //
public class UserRepoTests {

    @Autowired
    private UserRepo userRepo;
    private static User testUser = null;

    @Test
    @Order(1)
    public void createUser() {
        User testUser = new User("Ryan210","Ryan","BeGell","Password");
        UserRepoTests.testUser = userRepo.save(testUser);
        Assertions.assertEquals("Ryan210", testUser.getUsername());  //change to testUser
    }

    @Test
    @Order(2)
    public void findUserByUsername() {
        Optional<User> possibleUser = this.userRepo.findById(testUser.getUsername());
        if (possibleUser.isPresent()) {
            User user = possibleUser.get();
            Assertions.assertEquals("Ryan210", user.getUsername()); //change to Ryan25
        } else {
            throw new RuntimeException("User: " + testUser.getUsername() + " not found");
        }
    }

    @Test
    @Order(3)
    public void deleteUser(){
        userRepo.deleteById(testUser.getUsername());
        Optional<User> possibleUser = this.userRepo.findById(testUser.getUsername());
        Assertions.assertFalse(possibleUser.isPresent());
        //test user removed from db
    }
}


