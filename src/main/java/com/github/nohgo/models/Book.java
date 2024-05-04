package com.github.nohgo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book extends LibraryItem{
    @Column(name = "Author") private String author;
}
