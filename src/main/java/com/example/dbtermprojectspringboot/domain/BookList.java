package com.example.dbtermprojectspringboot.domain;

public class BookList {
    private String idBooks;
    private String numberOfBooks;

    public BookList() {
    }

    public BookList(String idBooks, String numberOfBooks) {
        this.idBooks = idBooks;
        this.numberOfBooks = numberOfBooks;
    }

    public String getIdBooks() {
        return idBooks;
    }

    public String getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setIdBooks(String idBooks) {
        this.idBooks = idBooks;
    }

    public void setNumberOfBooks(String numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
}

