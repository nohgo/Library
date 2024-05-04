package com.github.nohgo.repositories;

import com.github.nohgo.models.Book;
import com.github.nohgo.models.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    List<Book> findAllByAuthor(String author);
    List<Book> findAll();
    List<Book> findAllByIsBorrowed(Boolean isBorrowed);
    List<Book> findAllByTitle(String title);
}
