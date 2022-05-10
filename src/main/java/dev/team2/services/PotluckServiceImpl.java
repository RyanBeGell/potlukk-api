package dev.team2.services;

import dev.team2.entities.Potluck;
import dev.team2.repos.PotluckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class PotluckServiceImpl implements PotluckService{

    @Autowired
    private PotluckRepo potluckRepo;

    @Override
    public Potluck createPotluck(Potluck potluck) {
        return this.potluckRepo.save(potluck);
    }
}
