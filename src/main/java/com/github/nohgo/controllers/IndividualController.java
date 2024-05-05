package com.github.nohgo.controllers;

import com.github.nohgo.models.Individual;
import com.github.nohgo.models.LibraryItem;
import com.github.nohgo.services.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class IndividualController {
    @Autowired
    private IndividualService individualService;

    @GetMapping("/getAll")
    public Iterable<LibraryItem> getIndividuals(@RequestAttribute("individual") Individual individual) {
        return individualService.getItemsByIndividual(individual);
    }
}
