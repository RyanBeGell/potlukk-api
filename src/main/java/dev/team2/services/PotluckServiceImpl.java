package dev.team2.services;
import dev.team2.entities.Potluck;
import dev.team2.repos.PotluckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class PotluckServiceImpl implements PotluckService{

    @Autowired
    private PotluckRepo potluckRepo;

    @Override
    public Potluck createPotluck(Potluck potluck) {
        return this.potluckRepo.save(potluck);
    }

    @Override
    public List<Potluck> getAllPotlucks() {
        return this.potluckRepo.findAll();
    }

    @Override
    public Potluck getPotluckbyId(int potluckId) {
        return potluckRepo.findById(potluckId).get();
    }

    @Override
    public Potluck updatePotluckDate(int id, long time) {
        Optional<Potluck> possiblePotluck = potluckRepo.findById(id);
        Potluck potluck;
        if(possiblePotluck.isPresent()){
            potluck = possiblePotluck.get();
            potluck.setDateTime(time);
            return potluckRepo.save(potluck);
        }else {
            throw new EntityNotFoundException("Potluck #[: " + id + "] not found.");
        }
    }

    @Override
    public boolean deletePotluck(int id) {
        this.potluckRepo.deleteById(id);
        return true;
    }
}
