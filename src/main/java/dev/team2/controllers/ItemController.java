package dev.team2.controllers;

import dev.team2.entities.Item;
import dev.team2.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@CrossOrigin("*")
public class ItemController {

    @Autowired
    public ItemService itemService;

    @PostMapping("/items")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }

    @GetMapping("/potlucks/{potluckId}/items")
    public List<Item> findItemsByPotluckId(@PathVariable int potluckId){
        return itemService.findItemsByPotluckId(potluckId);
    }

    @PatchMapping("items/{itemId}/fulfilled")
    public Item updateItem(@PathVariable int itemId){
        return itemService.updateStatus(itemId);
    }

    @DeleteMapping("items/{itemId}")
    public boolean deleteItem(@PathVariable int itemId){
        return(itemService.deleteItem(itemId));
    }
}
