package com.BookStore.service.impl;
import com.BookStore.dto.GenreBookResponseDTO;
import com.BookStore.dto.GenreRequestDTO;
import com.BookStore.dto.GenreResponseDTO;
import com.BookStore.entity.Book;
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
    private GenreRepository genreRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public GenreService(GenreRepository genreRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.genreRepository = genreRepository;
    }

    public List<GenreResponseDTO> getAllGenre(){
        List<Genre> genres = genreRepository.findAll();
        List<GenreResponseDTO> genredto = genres.stream().map(genre->
                {
                    GenreResponseDTO dto = modelMapper.map(genre, GenreResponseDTO.class);
//                    if (genre.getAuthorId() != null) {
//                        String authorName = genre.getAuthorId().getFirst_name() + " " + genre.getAuthorId().getLast_name();
//                        dto.setAuthorName(authorName);
//                    }
                    return dto;
                }
                ).collect(Collectors.toList());
        return genredto;

    }
    public GenreResponseDTO getAllGenreById(Integer id){
        Optional<Genre> genre = genreRepository.findById(id);
        GenreResponseDTO genredto = this.modelMapper.map(genre, GenreResponseDTO.class);
        return genredto;
    }
    public List<GenreBookResponseDTO> ListAllBooksGenreById(Integer id){
        List<GenreBookResponseDTO> genre = genreRepository.ListAllBooksGenreById(id);
        //GenreBookResponseDTO genredto = this.modelMapper.map(genre, GenreResponseDTO.class);
        return genre;
    }
    public Genre saveGenre(GenreRequestDTO g){
        Genre g1 = new Genre();
        g1.setDescription(g.getDescription());
        g1.setName(g.getName());
        return genreRepository.save(g1);
    }
    public Boolean deleteGenreById(Integer id){
       Optional<Genre> genre = genreRepository.findById(id);
        if(genre.isEmpty()){
            return false;
        }else {
            genreRepository.deleteById(id);
            return true;
        }
    }
}
