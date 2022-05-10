package dev.team2.Potlukk.applicationtests;

import dev.team2.entities.Item;
import dev.team2.repos.ItemRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ItemRepoTests {

    @Autowired

    private ItemRepo itemRepo;

    @Test
    public void create_item(){
        Item item = new Item(0, "Test Item 1", "Wanted", "Santa", 1);
        itemRepo.save(item);
        Assertions.assertNotEquals(0, item.getItemId());
    }

    @Test
    public void find_items_by_potluckId(){
        int potluckId = 1;
        List<Item> items = itemRepo.findItemsByPotluckId(potluckId);
        Assertions.assertNotNull(items);
        System.out.println(items);
    }

    @Test
    public void delete_item_by_itemId(){
        Item item = new Item(0, "Test Item 2", "Needed", "Chaz", 1);
        itemRepo.save(item);
        int itemId = item.getItemId();
        itemRepo.deleteById(itemId);
        Optional<Item> testItem = itemRepo.findById(itemId);
        Assertions.assertFalse(testItem.isPresent());
    }
}
