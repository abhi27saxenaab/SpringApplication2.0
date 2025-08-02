package com.BookStore.service;

import com.BookStore.dto.BookRequestDTO;
import com.BookStore.dto.BookResponseDTO;
import com.BookStore.entity.Book;

import java.util.List;

public interface BookService {
    List<BookResponseDTO> getAllBook();
    BookResponseDTO getAllBookById(Long id);
    Book saveBook(BookRequestDTO b);
    Boolean deleteBookById(Long id);

}
