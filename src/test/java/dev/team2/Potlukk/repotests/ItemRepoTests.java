package dev.team2.Potlukk.repotests;

import dev.team2.entities.Item;
import dev.team2.entities.Potluck;
import dev.team2.repos.ItemRepo;
import dev.team2.repos.PotluckRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //
public class ItemRepoTests {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private PotluckRepo potluckRepo;

    static Potluck testPotluck = null;
    static Item testItem = null;
    java.util.Date date = new Date();


    @Test
    @Order(1)
    public void create_item(){
        Potluck potluck = new Potluck(0, date.getTime(), "rbegell", true, "Community Potluck");
        ItemRepoTests.testPotluck = potluckRepo.save(potluck);
        Item item = new Item(0, "Test Item 1", "Wanted", "Santa", potluck.getPotluckID());
        ItemRepoTests.testItem = itemRepo.save(item);
        Assertions.assertNotEquals(0, testItem.getItemId());
    }

    @Test
    @Order(2)
    public void find_items_by_potluckId(){
        List<Item> items = itemRepo.findItemsByPotluckId(testPotluck.getPotluckID());
        int totalItems = items.size();
        Assertions.assertTrue(totalItems >=1 );
    }

    @Test
    @Order(3)
    public void delete_item_by_itemId(){
        itemRepo.deleteById(testItem.getItemId());
        Optional<Item> possibleItem = itemRepo.findById(testItem.getItemId());
        Assertions.assertFalse(possibleItem.isPresent());
    }
}
