package com.BookStore.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionRequestDTO {
    private int user_id;
    private int book_id;
    private Date checkout_date;
    private Date due_date;
    private Date return_date;
    private String status;
    private String notes;
}
