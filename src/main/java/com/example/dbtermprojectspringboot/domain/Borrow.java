package com.example.dbtermprojectspringboot.domain;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Borrow {
    private int borrowNumber;
    private String isbn;
    private String title;
    private String customerId;
    private Date borrowDate;
    private Date returnDate;
    private int isReturn;

    public int getBorrowNumber() {
        return borrowNumber;
    }

    public void setBorrowNumber(int borrowNumber) {
        this.borrowNumber = borrowNumber;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(int isReturn) {
        this.isReturn = isReturn;
    }
}
