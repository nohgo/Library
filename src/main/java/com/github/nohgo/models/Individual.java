package com.github.nohgo.models;

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
    @Column(name = "ID") private int id;
    @Column(name = "Username") private String username;
    @Column(name = "Password") private String password;
    @Column(name = "isAdmin", columnDefinition = "TINYINT")
    @Convert(converter = NumericBooleanConverter.class) private Boolean isAdmin;

    @OneToMany(mappedBy = "individual", cascade = CascadeType.ALL)
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
