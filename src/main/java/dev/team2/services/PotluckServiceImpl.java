package dev.team2.services;

import dev.team2.entities.Potluck;
import dev.team2.repos.PotluckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public String getPotluckUrl(int id) {
        return this.potluckRepo.getById(id).getUrl();
    }

    @Override
    public Potluck updatePotluckDate(int id, long time) {
        Potluck potluck = this.potluckRepo.getById(id);

        potluck.setDateTime(time);
        this.potluckRepo.save(potluck);

        return potluck;
    }

    @Override
    public boolean deletePotluck(int id) {
        this.potluckRepo.deleteById(id);
        return true;
    }
}
