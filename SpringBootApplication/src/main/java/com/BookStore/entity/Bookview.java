package com.BookStore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="bookview")
public class Bookview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int book_id;
    private int user_id;
    private int count;
}
