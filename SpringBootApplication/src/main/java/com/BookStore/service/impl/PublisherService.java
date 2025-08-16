package com.BookStore.service.impl;
import com.BookStore.dto.PublisherRequestDTO;
import com.BookStore.dto.PublisherResponseDTO;
import com.BookStore.entity.Publisher;
import com.BookStore.exception.PublisherNotFound;
import com.BookStore.repository.PublisherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublisherService {
    private PublisherRepository bookRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public PublisherService(PublisherRepository bookRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }

    public List<PublisherResponseDTO> getAllPublisher(){
        List<Publisher> books = bookRepository.findAll();
        List<PublisherResponseDTO> bookdto = books.stream().map(book->
                {
                    PublisherResponseDTO dto = modelMapper.map(book, PublisherResponseDTO.class);
//                    if (book.getAuthorId() != null) {
//                        String authorName = book.getAuthorId().getFirst_name() + " " + book.getAuthorId().getLast_name();
//                        dto.setAuthorName(authorName);
//                    }
                    return dto;
                }
                ).collect(Collectors.toList());
        return bookdto;

    }
    public Publisher getAllPublisherById(Integer id){
        Publisher book = bookRepository.findById(id).orElseThrow(()-> new PublisherNotFound("Not found: " + id));
        //PublisherResponseDTO bookdto = this.modelMapper.map(book, PublisherResponseDTO.class);
        return book;
    }
    public Publisher savePublisher(PublisherRequestDTO p){
        Publisher p1 = new Publisher();
        p1.setName(p.getName());
        p1.setAddress(p.getAddress());
        p1.setPhone(p.getPhone());
        p1.setEmail(p.getEmail());
        p1.setWebsite(p.getWebsite());
        return bookRepository.save(p1);
    }
    public Boolean deletePublisherById(Integer id){
       Optional<Publisher> book = bookRepository.findById(id);
        if(book.isEmpty()){
            return false;
        }else {
            bookRepository.deleteById(id);
            return true;
        }
    }
}
