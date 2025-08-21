package com.BookStore.service.impl;
import com.BookStore.dto.BookRequestDTO;
import com.BookStore.dto.BookResponseDTO;
import com.BookStore.dto.BookviewDTO;
import com.BookStore.entity.Author;
import com.BookStore.entity.Book;
import com.BookStore.entity.Bookview;
import com.BookStore.entity.Genre;
import com.BookStore.repository.AuthorRepository;
import com.BookStore.repository.BookRepository;
import com.BookStore.repository.BookviewRepositoty;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;

    private BookviewRepositoty bookviewRepositoty;

    private final ModelMapper modelMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookviewRepositoty bookviewRepositoty, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
        this.bookviewRepositoty = bookviewRepositoty;
    }
    public Page<BookResponseDTO> getAllBookWithPaging(int page, int size) {
        // Create pageable request
        Pageable pageable = PageRequest.of(page, size);

        // Get paged data from repository
        Page<Book> bookPage = bookRepository.findAll(pageable);

        // Convert to DTO page
        return bookPage.map(book -> {
            BookResponseDTO dto = modelMapper.map(book, BookResponseDTO.class);
            if (book.getAuthorId() != null) {
                String authorName = book.getAuthorId().getFirst_name() + " " + book.getAuthorId().getLast_name();
                dto.setAuthorName(authorName);
            }
            if (book.getGenreId() != null) {
                String genreName = book.getGenreId().getName();
                dto.setGenreName(genreName);
            }
            return dto;
        });
    }

    public List<BookResponseDTO> getAllBook(){
        List<Book> books = bookRepository.findAll();
        List<BookResponseDTO> bookdto = books.stream().map(book->
                {
                    BookResponseDTO dto = modelMapper.map(book, BookResponseDTO.class);
                    if (book.getAuthorId() != null) {
                        String authorName = book.getAuthorId().getFirst_name() + " " + book.getAuthorId().getLast_name();
                        dto.setAuthorName(authorName);
                    }
                    if (book.getGenreId() != null) {
                        String genreName = book.getGenreId().getName();
                        dto.setGenreName(genreName);
                    }
                    return dto;
                }
                ).collect(Collectors.toList());
        return bookdto;
    }
    public BookResponseDTO getAllBookById(Integer id){
        Optional<Book> book = bookRepository.findById(id);
        BookResponseDTO bookdto = this.modelMapper.map(book, BookResponseDTO.class);
        return bookdto;
    }
    public Book saveBook(BookRequestDTO b){
        Book b1 = new Book();
        Author a1 =new Author();
        a1.setAuthor_id(b.getAuthorId());

        Genre g1 =new Genre();
        g1.setGenre_id(b.getGenre_id());

        b1.setTitle(b.getTitle());
        b1.setIsbn(b.getIsbn());
        b1.setAuthorId(a1);
        b1.setPublisher_id(b.getPublisher_id());
        b1.setGenreId(g1);
        //b1.setGenre_id(b.getGenre_id());
        b1.setIsbn(b.getIsbn());
        b1.setPublication_date(b.getPublication_date());
        b1.setEdition(b.getEdition());
        b1.setLanguage(b.getLanguage());
        b1.setPage_count(b.getPage_count());
        b1.setDescription(b.getDescription());
        b1.setCover_image(b.getCover_image());
        b1.setQuantity_in_stock(b.getQuantity_in_stock());
        b1.setStatus(b.getStatus());
        b1.setBookcondition(b.getBookcondition());
        b1.setAcquisition_date(b.getAcquisition_date());
        b1.setAcquisition_price(b.getAcquisition_price());
        b1.setBarcode(b.getBarcode());
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
    public List<BookResponseDTO> getAllBookWithAuthor(Integer id){
        List<Book> books =  bookRepository.findAll();
        List<BookResponseDTO> bookdto = books.stream().map(book -> {
            List<BookviewDTO> bookview = bookviewRepositoty.findBookView(book.getBookId());
            String userView = bookview.stream().map(b->b.getFirst_name() + b.getLast_name()).distinct().collect(Collectors.joining(","));
            BookResponseDTO bo = modelMapper.map(book,BookResponseDTO.class);
            bo.setAuthorName1(userView);
            return bo;
        }).collect(Collectors.toList());
        return bookdto;
    }
}
