package com.BookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class GenreBookResponseDTO {
    private String title;
    private int generic_id;
    private int isbn;
    public GenreBookResponseDTO(String title, int generic_id, int isbn) {
        this.title = title;
        this.generic_id = generic_id;
        this.isbn = isbn;
    }
}
