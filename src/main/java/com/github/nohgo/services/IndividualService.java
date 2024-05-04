package com.github.nohgo.services;

import com.github.nohgo.repositories.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.nohgo.models.Individual;

import java.util.List;

@Service
public class IndividualService {

    @Autowired
    private IndividualRepository individualRepository;

    public List<Individual> getAllIndividuals() {
        return individualRepository.findAll();
    }

    public Individual saveIndividual(Individual individual) {
        return individualRepository.save(individual);
    }

    public Individual Login(String username, String password) {
        Individual potential =  individualRepository.findByUsername(username).orElse(null);
        if (potential == null) {
            return null;
        }
        if (potential.getPassword().equals(password)) {
            return potential;
        }
        return null;
    }

}
