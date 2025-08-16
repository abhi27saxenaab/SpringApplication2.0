package com.BookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class GenreBookResponseDTO {
    private String title;
    private int generic_id;
    private String isbn;

    private String genre_name;

    public GenreBookResponseDTO(String title, int generic_id, String isbn, String genre_name) {
        this.title = title;
        this.generic_id = generic_id;
        this.isbn = isbn;
        this.genre_name = genre_name;
    }
}
