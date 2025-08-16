package com.BookStore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="publishers")
@Setter
@Getter
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisher_id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String website;
}
