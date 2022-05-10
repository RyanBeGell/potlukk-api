package dev.team2.services;

import dev.team2.entities.Item;

import java.util.List;

public interface ItemService {

    Item createItem(Item item);

    List<Item> findItemsByPotluckId(int potluckId);

    Item updateStatus(int itemId);

    String deleteItem(int itemId);

}
