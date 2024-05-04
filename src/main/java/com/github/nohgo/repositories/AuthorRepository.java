package com.github.nohgo.repositories;

import com.github.nohgo.models.Author;
import com.github.nohgo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAll();
    Author save(Author author);
    Author findById(int id);
    Author findByName(String name);
}
