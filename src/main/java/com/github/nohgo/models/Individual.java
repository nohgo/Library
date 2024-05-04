package com.github.nohgo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "individuals")
@Getter
@Setter
public class Individual {
    @Id
    @Column(name = "ID") private int id;
    @Column(name = "Username") private String username;
    @Column(name = "Password") private String password;
    @Column(name = "isAdmin") private boolean isAdmin;
}
