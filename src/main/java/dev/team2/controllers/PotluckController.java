package dev.team2.controllers;

import dev.team2.entities.Potluck;
import dev.team2.services.PotluckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@CrossOrigin("*")
public class PotluckController {

    @Autowired
    private PotluckService potluckService;

    @PostMapping("/potlucks")
    public Potluck createPotluck(@RequestBody Potluck potluck){
        return this.potluckService.createPotluck(potluck);
    }

    @GetMapping("/potlucks")
    public List<Potluck> getAllPotlucks(){
        return this.potluckService.getAllPotlucks();
    }

    @PatchMapping("potlucks/{id}")
    public Potluck updatePotluckTime(@PathVariable int id, @RequestBody long time){
        return this.potluckService.updatePotluckDate(id, time);
    }

    @DeleteMapping("potlucks/{id}")
    public boolean deletePotluck(@PathVariable int id){
        return this.potluckService.deletePotluck(id);
    }
}