package com.github.nohgo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "books")
@Getter
@Setter
public class Book extends LibraryItem{
    @ManyToOne
    @JoinColumn(name = "author") private Author author;

    @Override
    public String toString() {
        return super.toString() + ", Author: " + author.getName();
    }
}
