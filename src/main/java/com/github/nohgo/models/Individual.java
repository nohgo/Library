package com.github.nohgo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.NumericBooleanConverter;

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


}
