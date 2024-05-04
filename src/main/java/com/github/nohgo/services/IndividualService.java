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

    public Individual getIndividualById(int id) {
        return individualRepository.findById(id).orElse(null);
    }

    public Individual getIndividualByUsername(String username) {
        return individualRepository.findByUsername(username).orElse(null);
    }


}
