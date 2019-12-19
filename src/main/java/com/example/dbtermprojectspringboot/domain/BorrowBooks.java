package com.example.dbtermprojectspringboot.domain;

public class BorrowBooks {
    private int idborrowBooks;
    private int idBooks;
    private String userID;
    private String borrowedDate;
    private String expectedReturn;
    private String isReturned;

    public BorrowBooks() {
    }

    public BorrowBooks(int idborrowBooks, int idBooks, String userID, String borrowedDate, String expectedReturn, String isReturned) {
        this.idborrowBooks = idborrowBooks;
        this.idBooks = idBooks;
        this.userID = userID;
        this.borrowedDate = borrowedDate;
        this.expectedReturn = expectedReturn;
        this.isReturned = isReturned;
    }

    public int getIdborrowBooks() {
        return idborrowBooks;
    }

    public int getIdBooks() {
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

    public void setIdborrowBooks(int idborrowBooks) {
        this.idborrowBooks = idborrowBooks;
    }

    public void setIdBooks(int idBooks) {
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
