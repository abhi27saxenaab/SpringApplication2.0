package com.BookStore.service;

import com.BookStore.dto.GenreRequestDTO;
import com.BookStore.dto.GenreResponseDTO;
import com.BookStore.entity.Genre;

import java.util.List;

public interface GenreService {
    List<GenreResponseDTO> getAllGenre();
    GenreResponseDTO getAllGenreById(Long id);
    Genre saveGenre(GenreRequestDTO b);
    Boolean deleteGenreById(Long id);

}
