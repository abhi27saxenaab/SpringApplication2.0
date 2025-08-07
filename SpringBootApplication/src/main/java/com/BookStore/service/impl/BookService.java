package com.BookStore.service.impl;
import com.BookStore.dto.BookRequestDTO;
import com.BookStore.dto.BookResponseDTO;
import com.BookStore.entity.Book;
import com.BookStore.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public BookService(BookRepository bookRepository,ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }

    public List<BookResponseDTO> getAllBook(){
        List<Book> books = bookRepository.findAll();
        List<BookResponseDTO> bookdto = books.stream().map(book-> modelMapper.map(book, BookResponseDTO.class)).collect(Collectors.toList());
        return bookdto;

    }
    public BookResponseDTO getAllBookById(Integer id){
        Optional<Book> book = bookRepository.findById(id);
        BookResponseDTO bookdto = this.modelMapper.map(book, BookResponseDTO.class);
        return bookdto;
    }
    public Book saveBook(BookRequestDTO b){
        Book b1 = new Book();
        b1.setTitle(b.getTitle());
        b1.setIsbn(b.getIsbn());
        b1.setAuthorId(b.getAuthorId());
        return bookRepository.save(b1);
    }
    public Boolean deleteBookById(Integer id){

        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            return false;
        }else {
            bookRepository.deleteById(id);
            return true;
        }
    }
}
