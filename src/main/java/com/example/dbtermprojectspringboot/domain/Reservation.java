package com.example.dbtermprojectspringboot.domain;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
public class Reservation {
    private String customerId;
    private String isbn;
    private Date reservDate;

    @Builder
    public Reservation(String customerId, String isbn, Date reservDate) {
        this.customerId = customerId;
        this.isbn = isbn;
        this.reservDate = reservDate;
    }
}
