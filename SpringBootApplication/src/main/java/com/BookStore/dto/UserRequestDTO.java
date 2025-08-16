package com.BookStore.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserRequestDTO {
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
