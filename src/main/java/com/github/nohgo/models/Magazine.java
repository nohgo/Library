package com.github.nohgo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "magazines")
@Getter
@Setter
public class Magazine extends LibraryItem {
    @Column(name = "IssueNumber")
    private int issueNumber;
}
