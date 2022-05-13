package dev.team2.services;

import dev.team2.entities.Potluck;

import java.util.List;

public interface PotluckService {

    Potluck createPotluck(Potluck potluck);

    List<Potluck> getAllPotlucks();

    Potluck updatePotluckDate(int id, long time);

    boolean deletePotluck(int id);
}
