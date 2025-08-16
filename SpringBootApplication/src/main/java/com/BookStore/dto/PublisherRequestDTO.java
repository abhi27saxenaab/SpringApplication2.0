package com.BookStore.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PublisherRequestDTO {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String website;
}
