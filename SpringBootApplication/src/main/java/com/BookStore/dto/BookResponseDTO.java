package com.BookStore.dto;

import lombok.Data;

@Data
public class BookResponseDTO {
    private String title;
    private String isbn;
    private int authorId;
}
