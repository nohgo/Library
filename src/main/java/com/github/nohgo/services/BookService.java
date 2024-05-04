package com.github.nohgo.services;

import com.github.nohgo.models.Book;
import com.github.nohgo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public List<Book> findAllByIsBorrowed(Boolean isBorrowed) {
        return bookRepository.findAllByIsBorrowed(isBorrowed);
    }
    public List<Book> findAllByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }
}
