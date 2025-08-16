package com.BookStore.controller;

import com.BookStore.dto.GenreBookResponseDTO;
import com.BookStore.dto.GenreRequestDTO;
import com.BookStore.dto.GenreResponseDTO;
import com.BookStore.entity.Genre;
import com.BookStore.service.impl.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    private GenreService GenreService;

    @Autowired
    public GenreController(GenreService GenreService){
        this.GenreService=GenreService;
    }
    @GetMapping("/allbooks/{id}")
    public ResponseEntity<List<Genre>> ListAllBooksGenreById(@PathVariable Integer id){
        List<GenreBookResponseDTO> Genres=  this.GenreService.ListAllBooksGenreById(id);
        return new ResponseEntity(Genres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Genre>> ListGenreById(@PathVariable Integer id){
        GenreResponseDTO Genres=  this.GenreService.getAllGenreById(id);
        return new ResponseEntity(Genres, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Genre>> ListAllGenre(){
        List<GenreResponseDTO> Genres=  this.GenreService.getAllGenre();
        return new ResponseEntity(Genres, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Genre> saveGenre(@RequestBody GenreRequestDTO u){
        Genre Genre=  this.GenreService.saveGenre(u);
        return new ResponseEntity(Genre, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Boolean DeleteGenreById(@PathVariable Integer id){
        Boolean isDeleted=  this.GenreService.deleteGenreById(id);
        return isDeleted;
    }
}
