package com.BookStore.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GenreResponseDTO {
    private int genre_id;
    private String name;
    private String description;
}
