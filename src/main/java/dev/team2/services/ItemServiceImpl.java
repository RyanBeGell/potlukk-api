package dev.team2.services;

import dev.team2.entities.Item;
import dev.team2.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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
        Optional<Item> possibleItem = itemRepo.findById(itemId);
        if(possibleItem.isPresent()) {
            Item item = possibleItem.get();
            item.setStatus("Fulfilled");
            return itemRepo.save(item);
        }else{
            throw new EntityNotFoundException("Item #[" + itemId + "] not found.");
        }
    }

    @Override
    public boolean deleteItem(int itemId) {
        itemRepo.deleteById(itemId);
        Optional<Item> possibleItem = itemRepo.findById(itemId);
        return !possibleItem.isPresent();   //return true if deleted, false if still exists.
    }
}
