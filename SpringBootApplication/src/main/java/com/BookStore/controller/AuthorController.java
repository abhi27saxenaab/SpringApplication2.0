package com.BookStore.controller;

import com.BookStore.dto.AuthorRequestDTO;
import com.BookStore.dto.AuthorResponseDTO;
import com.BookStore.entity.Author;
import com.BookStore.service.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @GetMapping("/{id}")
    public AuthorResponseDTO getAllAuthorById(@PathVariable Integer id){
        return authorService.getAllAuthorById(id);
    }
    @GetMapping
    public List<AuthorResponseDTO> getAllAuthor(){
        return authorService.getAllAuthor();
    }
    @PostMapping
    public Author saveAuthor(@RequestBody AuthorRequestDTO author){
        return authorService.saveAuthor(author);
    }
    @PostMapping("/{id}")
    public Boolean deleteAuthorById(@PathVariable Integer id){
        return authorService.deleteAuthorById(id);
    }
}
