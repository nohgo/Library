package com.github.nohgo.controllers;

import com.github.nohgo.models.Magazine;
import com.github.nohgo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/magazines")
public class MagazineController {
    @Autowired
    private MagazineService magazineService;

    @GetMapping("/getAll")
    public Iterable<Magazine> getMagazines() {
        return magazineService.getAllMagazines();
    }
    @GetMapping("/getByTitle")
    public Iterable<Magazine> getMagazineByTitle(@RequestParam("title") String title) {
        return magazineService.findAllMagazinesByTitle(title);
    }
    @GetMapping("/getByIsBorrowed")
    public Iterable<Magazine> getMagazineByIsBorrowed(@RequestParam("isBorrowed") Boolean isBorrowed) {
        return magazineService.findAllMagazinesByIsBorrowed(isBorrowed);
    }





}
