package com.github.nohgo.models;

import java.time.LocalDate;

public class DateWritten {
    private final LocalDate date;

    public DateWritten(LocalDate date) {
        this.date = date;
    }
    public LocalDate getDateWritten() {
        return date;
    }
}
