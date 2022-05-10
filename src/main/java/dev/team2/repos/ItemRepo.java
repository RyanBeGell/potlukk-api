package dev.team2.repos;

import dev.team2.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

    List<Item> findItemsByPotluckId (int potluckId);
}
