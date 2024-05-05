package com.github.nohgo.controllers;

import com.github.nohgo.models.Book;
import com.github.nohgo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/getAll")
    public Iterable<Book> getBooks() {
        return bookService.findAll();
    }
    @GetMapping("/getByTitle")
    public Iterable<Book> getBookByTitle(@RequestParam String title) {
        return bookService.findAllByTitle(title);
    }
    @GetMapping("/getByIsBorrowed")
    public Iterable<Book> getBookByIsBorrowed(@RequestParam Boolean isBorrowed) {
        return bookService.findAllByIsBorrowed(isBorrowed);
    }
}
