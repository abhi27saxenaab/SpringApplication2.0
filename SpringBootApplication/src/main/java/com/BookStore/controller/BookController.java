package com.BookStore.controller;

import com.BookStore.dto.BookRequestDTO;
import com.BookStore.dto.BookResponseDTO;
import com.BookStore.entity.Book;
import com.BookStore.service.impl.BookService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping("/{id}")
    public BookResponseDTO getAllBookById(@PathVariable Integer id){
        return bookService.getAllBookById(id);
    }
    @GetMapping
    public List<BookResponseDTO> getAllBook(){
        return bookService.getAllBook();
    }
    @PostMapping
    public Book saveBook(@RequestBody BookRequestDTO book){
        return bookService.saveBook(book);
    }
    @PostMapping("/{id}")
    public Boolean deleteBookById(@PathVariable Integer id){
        return bookService.deleteBookById(id);
    }
}
