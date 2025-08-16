package com.BookStore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="users")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String address;
    private Date date_of_birth;
    private Date registration_date;
    private String membership_type;
    private String status;
}
