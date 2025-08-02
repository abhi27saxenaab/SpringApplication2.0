package com.BookStore.dto;

import lombok.Data;

@Data
public class BookRequestDTO {
    private String title;
    private String isbn;
    private int authorId;
}
