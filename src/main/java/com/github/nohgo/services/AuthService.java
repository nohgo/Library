package com.github.nohgo.services;

import com.github.nohgo.models.Individual;
import com.github.nohgo.repositories.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private IndividualRepository individualRepository;

    public Individual login(String username, String password) {
        return individualRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
    public void register(String username, String password) {
        if (individualRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        Individual individual = new Individual();
        individual.setUsername(username);
        individual.setPassword(password);
        individualRepository.save(individual);
    }
}
