package com.github.nohgo.controllers;

import com.github.nohgo.models.Author;
import com.github.nohgo.models.Book;
import com.github.nohgo.models.Magazine;
import com.github.nohgo.requests.BookRequest;
import com.github.nohgo.requests.MagazineRequest;
import com.github.nohgo.services.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private IndividualService individualService;
    @Autowired
    private LibraryItemService libraryItemService;
    @Autowired
    private AuthService authService;

    @PostMapping("/addBook")
    public void addBook(@NonNull @RequestBody BookRequest bookRequest) {
        Author author = authorService.findByName(bookRequest.getAuthor());
        if (author == null) {
            author = new Author();
            author.setName(bookRequest.getAuthor());
            authorService.save(author);
        }
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(author);
        author.addBook(book);

        authorService.save(author);
        libraryItemService.saveLibraryItem(book);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@NonNull @RequestBody String title) {
        try {
            libraryItemService.removeByTitle(title);
            return ResponseEntity.ok("Book deleted successfully");
        } catch (Exception ignored) {}
        return ResponseEntity.badRequest().body("Book not found");
    }

    @PostMapping("/addMagazine")
    public void addMagazine(@NonNull @RequestBody MagazineRequest magazineRequest) {
        Magazine magazine = new Magazine();
        magazine.setTitle(magazineRequest.getTitle());
        magazine.setIssueNumber(magazineRequest.getIssueNumber());

        libraryItemService.saveLibraryItem(magazine);
    }
    @DeleteMapping("/deleteMagazine")
    public ResponseEntity<String> deleteMagazine(@NonNull @RequestBody String title) {
        try {
            libraryItemService.removeByTitle(title);
            return ResponseEntity.ok("Magazine deleted successfully");
        } catch (Exception ignored) {}
        return ResponseEntity.badRequest().body("Magazine not found");
    }

    @PostMapping("/promoteToAdmin")
    public ResponseEntity<String> promoteToAdmin(@NonNull @RequestBody String username) {
        try {
            authService.promoteToAdmin(individualService.getIndividualByUsername(username));
            return ResponseEntity.ok("User promoted to admin successfully");
        } catch (Exception ignored) {}
        return ResponseEntity.badRequest().body("User not found");
    }

}
