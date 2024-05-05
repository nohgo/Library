package com.github.nohgo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "ID") private int id;
    @Column(name = "Name") private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "books")
    private List<Book> books;

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }
}
