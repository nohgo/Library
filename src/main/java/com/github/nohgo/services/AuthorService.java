package com.github.nohgo.services;

import com.github.nohgo.models.Author;
import com.github.nohgo.models.Book;
import com.github.nohgo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }
    public Author save(Author author) {
        return authorRepository.save(author);
    }
    public Author findById(int id) {
        return authorRepository.findById(id);
    }
    public Author findByName(String name) {
        return authorRepository.findByName(name);
    }
    public List<Book> findBooksByAuthor(Author author) {
        return author.getBooks();
    }
}
