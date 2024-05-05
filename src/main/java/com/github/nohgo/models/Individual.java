package com.github.nohgo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.NumericBooleanConverter;

import java.util.List;

@Entity
@Table(name = "individuals")
@Getter
@Setter
public class Individual {
    @Id
    @GeneratedValue
    @JsonIgnore
    @Column(name = "ID") private int id;
    @Column(name = "Username") private String username;
    @Column(name = "Password") private String password;
    @Column(name = "isAdmin", columnDefinition = "TINYINT")
    @Convert(converter = NumericBooleanConverter.class) private Boolean isAdmin = false;

    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "borrowed_items")
    private List<LibraryItem> items;

    public boolean hasItem (LibraryItem item) {
        return items.contains(item);
    }
    public void borrowItem (LibraryItem item) {
        items.add(item);
    }
    public void returnItem (LibraryItem item) {
        items.remove(item);
    }

}
