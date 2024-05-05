package com.github.nohgo.controllers;

import com.github.nohgo.models.Individual;
import com.github.nohgo.models.LibraryItem;
import com.github.nohgo.services.LibraryItemService;
import com.github.nohgo.services.LibraryService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class LibraryItemController {
    @Autowired
    private LibraryItemService libraryItemService;
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/getAll")
    public Iterable<LibraryItem> getLibraryItems() {
        return libraryItemService.getAllLibraryItems();
    }
    @GetMapping("/getByTitle")
    public LibraryItem getLibraryItemByTitle(@NonNull @RequestParam("title") String title) {
        return libraryItemService.findByTitle(title).orElse(null);
    }
    @GetMapping("/getByIsBorrowed")
    public Iterable<LibraryItem> getLibraryItemByIsBorrowed(@NonNull @RequestParam("isBorrowed") Boolean isBorrowed) {
        return libraryItemService.findByIsBorrowed(isBorrowed);
    }
    @PostMapping("/borrow")
    public ResponseEntity<String> borrowLibraryItem(@NonNull @RequestParam("title") String title, @RequestAttribute("individual") Individual individual) {
        try {
            libraryService.borrowItem(individual, title);
            return ResponseEntity.ok("Item borrowed successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }
    @PostMapping("/return")
    public ResponseEntity<String> returnLibraryItem(@NonNull @RequestParam("title") String title, @RequestAttribute("individual") Individual individual) {
        try {
            libraryService.returnItem(individual, title);
            return ResponseEntity.ok("Item returned successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
