package com.BookStore.service.impl;
import com.BookStore.dto.GenreRequestDTO;
import com.BookStore.dto.GenreResponseDTO;
import com.BookStore.entity.Genre;
import com.BookStore.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService {
    private GenreRepository bookRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public GenreService(GenreRepository bookRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }

    public List<GenreResponseDTO> getAllGenre(){
        List<Genre> books = bookRepository.findAll();
        List<GenreResponseDTO> bookdto = books.stream().map(book->
                {
                    GenreResponseDTO dto = modelMapper.map(book, GenreResponseDTO.class);
//                    if (book.getAuthorId() != null) {
//                        String authorName = book.getAuthorId().getFirst_name() + " " + book.getAuthorId().getLast_name();
//                        dto.setAuthorName(authorName);
//                    }
                    return dto;
                }
                ).collect(Collectors.toList());
        return bookdto;

    }
    public GenreResponseDTO getAllGenreById(Integer id){
        Optional<Genre> book = bookRepository.findById(id);
        GenreResponseDTO bookdto = this.modelMapper.map(book, GenreResponseDTO.class);
        return bookdto;
    }
    public Genre saveGenre(GenreRequestDTO g){
        Genre g1 = new Genre();
        g1.setDescription(g.getDescription());
        g1.setName(g.getName());
        return bookRepository.save(g1);
    }
    public Boolean deleteGenreById(Integer id){
       Optional<Genre> book = bookRepository.findById(id);
        if(book.isEmpty()){
            return false;
        }else {
            bookRepository.deleteById(id);
            return true;
        }
    }
}
