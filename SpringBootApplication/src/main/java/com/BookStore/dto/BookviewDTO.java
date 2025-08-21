package com.BookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookviewDTO {
    private int id;
    private int book_id;
    private int user_id;
    private int count;
    private String first_name;
    private String last_name;
}
