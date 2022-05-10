package dev.team2.services;

import dev.team2.entities.Item;
import dev.team2.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public Item createItem(Item item) {
        this.itemRepo.save(item);
        return item;
    }

    @Override
    public List<Item> findItemsByPotluckId(int potluckId) {
        return itemRepo.findItemsByPotluckId(potluckId);
    }

    @Override
    public Item updateStatus(int itemId) {
        Item item = itemRepo.findById(itemId).get();
        item.setStatus("Fulfilled");
        itemRepo.save(item);
        return item;
    }

    @Override
    public String deleteItem(int itemId) {
        itemRepo.deleteById(itemId);
        return "Item Was Deleted Successfully";
    }
}
