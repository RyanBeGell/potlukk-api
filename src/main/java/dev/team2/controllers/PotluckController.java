package dev.team2.controllers;

import dev.team2.entities.Potluck;
import dev.team2.services.PotluckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class PotluckController {

    @Autowired
    private PotluckService potluckService;

    @PostMapping("/potlucks")
    public Potluck createPotluck(@RequestBody Potluck potluck){
        return this.potluckService.createPotluck(potluck);
    }
}
