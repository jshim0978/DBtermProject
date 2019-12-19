package com.example.dbtermprojectspringboot.domain;

public class BorrowBooks {
    private String idborrowBooks;
    private String idBooks;
    private String userID;
    private String borrowedDate;
    private String expectedReturn;
    private String isReturned;

    public BorrowBooks() {
    }

    public BorrowBooks(String idborrowBooks, String idBooks, String userID, String borrowedDate, String expectedReturn, String isReturned) {
        this.idborrowBooks = idborrowBooks;
        this.idBooks = idBooks;
        this.userID = userID;
        this.borrowedDate = borrowedDate;
        this.expectedReturn = expectedReturn;
        this.isReturned = isReturned;
    }

    public String getIdborrowBooks() {
        return idborrowBooks;
    }

    public String getIdBooks() {
        return idBooks;
    }

    public String getUserID() {
        return userID;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public String getExpectedReturn() {
        return expectedReturn;
    }

    public String getIsReturned() {
        return isReturned;
    }

    public void setIdborrowBooks(String idborrowBooks) {
        this.idborrowBooks = idborrowBooks;
    }

    public void setIdBooks(String idBooks) {
        this.idBooks = idBooks;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public void setExpectedReturn(String expectedReturn) {
        this.expectedReturn = expectedReturn;
    }

    public void setIsReturned(String isReturned) {
        this.isReturned = isReturned;
    }
}
