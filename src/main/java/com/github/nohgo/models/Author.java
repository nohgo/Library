package com.github.nohgo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @Column(name = "ID") private int id;
    @Column(name = "Name") private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "books")
    @JsonIgnore
    private List<Book> books;

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }
}
