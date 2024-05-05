package com.github.nohgo.controllers;

import com.github.nohgo.models.Book;
import com.github.nohgo.services.BookService;
import io.micrometer.common.lang.NonNull;
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
    public Iterable<Book> getBookByTitle(@NonNull @RequestParam("title") String title) {
        return bookService.findAllByTitle(title);
    }
    @GetMapping("/getByIsBorrowed")
    public Iterable<Book> getBookByIsBorrowed(@NonNull @RequestParam("isBorrowed") Boolean isBorrowed) {
        return bookService.findAllByIsBorrowed(isBorrowed);
    }
}
