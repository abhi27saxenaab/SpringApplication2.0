package com.BookStore.dto;
import lombok.Data;
import java.util.Date;

@Data
public class AuthorRequestDTO {
    private String first_name;
    private String last_name;
    private Date date_of_birth;
    private Date date_of_death;
    private String biography;
}
