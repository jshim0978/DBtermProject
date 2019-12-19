package com.example.dbtermprojectspringboot.domain;

import java.util.Optional;

public class Book {
    private int idBooks;
    private String bookAuthor;
    private String bookName;
    private String bookPublisher;

    public Book(int idBooks, String bookAuthor, String bookName, String bookPublisher) {
        this.idBooks = idBooks;
        this.bookAuthor = bookAuthor;
        this.bookName = bookName;
        this.bookPublisher = bookPublisher;
    }

    public int getIdBooks() {
        return idBooks;
    }

    public void setIdBooks(int idBooks) {
        this.idBooks = idBooks;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }


}
