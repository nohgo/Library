package com.github.nohgo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private int id;
    @Column(name = "Title")
    private String title;
    @Column(name = "isBorrowed", columnDefinition = "TINYINT")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isBorrowed = false;

    @JoinColumn(name = "borrower")
    @ManyToOne
    @JsonIgnore
    private Individual borrower;

    @Override
    public String toString() {
        return "Title: " + title;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        LibraryItem other = (LibraryItem) obj;
        return this.id == other.id;
    }

}
