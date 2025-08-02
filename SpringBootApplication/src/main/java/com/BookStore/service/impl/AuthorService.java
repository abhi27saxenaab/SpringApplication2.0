package com.BookStore.service.impl;
import com.BookStore.dto.AuthorRequestDTO;
import com.BookStore.dto.AuthorResponseDTO;
import com.BookStore.entity.Author;
import com.BookStore.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public AuthorService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<AuthorResponseDTO> getAllAuthor(){
        List<Author> authors = authorRepository.findAll();
        List<AuthorResponseDTO> authordto = authors.stream().map(author-> modelMapper.map(author, AuthorResponseDTO.class)).collect(Collectors.toList());
        return authordto;

    }
    public AuthorResponseDTO getAllAuthorById(Integer id){
        Optional<Author> author = authorRepository.findById(id);
        AuthorResponseDTO authordto = this.modelMapper.map(author, AuthorResponseDTO.class);
        return authordto;
    }
    public Author saveAuthor(AuthorRequestDTO b){
        Author b1 = new Author();
        b1.setFirst_name(b.getFirst_name());
        b1.setLast_name(b.getLast_name());
        b1.setDate_of_death(b.getDate_of_death());
        b1.setDate_of_birth(b.getDate_of_birth());
        b1.setBiography(b.getBiography());
        return authorRepository.save(b1);
    }
    public Boolean deleteAuthorById(Integer id){

        Optional<Author> author = authorRepository.findById(id);
        if(author.isEmpty()){
            return false;
        }else {
            authorRepository.deleteById(id);
            return true;
        }
    }
}
