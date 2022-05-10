package dev.team2.Potlukk.potluckrepotests;

import dev.team2.entities.Potluck;
import dev.team2.repos.PotluckRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //
public class PotluckRepoTests {


    java.util.Date date = new Date();

    @Autowired
    private PotluckRepo potluckRepo;
    static Potluck testPotluck = null;

    @Test
    @Order(1)
    public void createPotluck(){
        Potluck potluck = new Potluck(0, date.getTime(), "rogerrabbit", true, "aaa4jsh5r");        //add fields after entity class commit
        PotluckRepoTests.testPotluck = potluckRepo.save(potluck);
        Assertions.assertNotEquals(0, testPotluck.getPotluckID());
    }

    @Test
    @Order(2)
    public void getAllPotlucks(){
        Potluck a = new Potluck();      //add fields
        Potluck b = new Potluck();      //add fields
        Potluck c = new Potluck();      //add fields
        potluckRepo.save(a);
        potluckRepo.save(b);
        potluckRepo.save(c);
        List<Potluck> potlucks = this.potluckRepo.findAll();
        int totalPotlucks = potlucks.size();
        //3 potlucks added, therefore getAll must return at least 3
        System.out.println(potlucks);
        Assertions.assertTrue(totalPotlucks >=3 );
    }

    @Test
    @Order(3)
    public void getPotluckById() {
        Optional<Potluck> possiblePotluck = this.potluckRepo.findById(1);
        Assertions.assertTrue(possiblePotluck.isPresent()); //assert that we received a potluck
        Potluck potluck = possiblePotluck.get();//use fields from saved potluck
        Assertions.assertNotEquals(0,testPotluck.getPotluckID());       //use fields from saved potluck
    }

    @Test
    @Order(4)
    public void updatePotluck(){
        PotluckRepoTests.testPotluck.setPrivate(true);
        potluckRepo.save(testPotluck);
        Optional<Potluck> possiblePotluck = potluckRepo.findById(testPotluck.getPotluckID());
        //assert that the potluck is retrieved
        Assertions.assertTrue(possiblePotluck.isPresent());
        Potluck potluck = possiblePotluck.get();
        //assert that the update was successful
        Assertions.assertTrue(potluck.isPrivate());
        }

    @Test
    @Order(5)
    public void deletePotluckById(){
        potluckRepo.deleteById(testPotluck.getPotluckID());
        Optional<Potluck> possiblePotluck = potluckRepo.findById(testPotluck.getPotluckID());
        //assert that the potluck is not present in the DB after deletion
        Assertions.assertFalse(possiblePotluck.isPresent());
    }

}
