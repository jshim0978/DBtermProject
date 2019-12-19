package com.example.dbtermprojectspringboot.domain;

public class ReturnApplication {
    private String idborrowBooks;

    public ReturnApplication() {
    }

    public ReturnApplication(String idborrowBooks) {
        this.idborrowBooks = idborrowBooks;
    }

    public String getIdborrowBooks() {
        return idborrowBooks;
    }

    public void setIdborrowBooks(String idborrowBooks) {
        this.idborrowBooks = idborrowBooks;
    }
}
