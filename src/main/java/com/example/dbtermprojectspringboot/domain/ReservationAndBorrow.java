package com.example.dbtermprojectspringboot.domain;

import java.util.Date;

public class ReservationAndBorrow extends Reservation {
    private int isBorrow;
    private String title;
    private int numberOfRestPerson;

    public ReservationAndBorrow(String customerId, String isbn, Date reservDate, int isBorrow, String title, int numberOfRestPerson) {
        super(customerId, isbn, reservDate);
        this.isBorrow = isBorrow;
        this.title = title;
        this.numberOfRestPerson = numberOfRestPerson;
    }

    public int getIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(int isBorrow) {
        this.isBorrow = isBorrow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfRestPerson() {
        return numberOfRestPerson;
    }

    public void setNumberOfRestPerson(int numberOfRestPerson) {
        this.numberOfRestPerson = numberOfRestPerson;
    }
}
