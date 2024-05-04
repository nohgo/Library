package com.github.nohgo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.NumericBooleanConverter;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "library_items")
@Getter
@Setter
public abstract class LibraryItem {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    @Column(name = "Title")
    private String title;
    @Column(name = "isBorrowed", columnDefinition = "TINYINT")
    @Convert(converter = NumericBooleanConverter.class) private Boolean isBorrowed = false;
    @JoinColumn(name = "borrower")
    @ManyToOne
    private Individual borrower;

    @Override
    public String toString() {
        return "Title: " + title;
    }
    public String getFullInfo() {
        return "Title: " + title + ", Borrowed: " + isBorrowed + ", Borrower: " + borrower.getUsername();
    }

}
