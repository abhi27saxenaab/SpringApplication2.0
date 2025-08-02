package com.BookStore.service;

import com.BookStore.dto.AuthorRequestDTO;
import com.BookStore.dto.AuthorResponseDTO;
import com.BookStore.entity.Author;

import java.util.List;

public interface AuthorService {
    List<AuthorResponseDTO> getAllAuthor();
    AuthorResponseDTO getAllAuthorById(Long id);
    Author saveAuthor(AuthorRequestDTO b);
    Boolean deleteAuthorById(Long id);
}
