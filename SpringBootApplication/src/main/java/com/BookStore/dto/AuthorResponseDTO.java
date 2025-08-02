package com.BookStore.dto;

import lombok.Data;

import java.util.Date;
@Data
public class AuthorResponseDTO {
    private int author_id;
    private String first_name;
    private String last_name;
    private Date date_of_birth;
    private Date date_of_death;
    private String biography;
}
