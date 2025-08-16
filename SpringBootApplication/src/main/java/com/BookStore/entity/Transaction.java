package com.BookStore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="transactions")
@Setter
@Getter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transaction_id;
    private int user_id;
    private int book_id;
    private Date checkout_date;
    private Date due_date;
    private Date return_date;
    private String status;
    private String notes;

}
