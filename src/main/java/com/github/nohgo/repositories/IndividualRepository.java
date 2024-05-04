package com.github.nohgo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.nohgo.models.Individual;

import java.util.List;
import java.util.Optional;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Integer>{
    List<Individual> findAll();
    Individual save(Individual individual);
    Optional<Individual> findByUsernameAndPassword(String username, String password);
    Optional<Individual> findByUsername(String username);
    Optional<Individual> findById(int id);
}
