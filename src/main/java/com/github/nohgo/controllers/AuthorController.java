package com.github.nohgo.controllers;

import com.github.nohgo.models.Author;
import com.github.nohgo.models.Book;
import com.github.nohgo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/getAll")
    public Iterable<Author> getAuthors() {
        return authorService.findAll();
    }
    @GetMapping("/getByName")
    public List<Book> getBooksByName(@RequestParam("name") String name) {
        return authorService.findBooksByAuthorByName(name);
    }

}
