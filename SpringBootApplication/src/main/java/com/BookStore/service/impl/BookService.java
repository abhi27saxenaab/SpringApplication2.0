package com.BookStore.service.impl;
import com.BookStore.dto.BookRequestDTO;
import com.BookStore.dto.BookResponseDTO;
import com.BookStore.entity.Author;
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

        b1.setTitle(b.getTitle());
        b1.setIsbn(b.getIsbn());
        b1.setAuthorId(a1);
        b1.setPublisher_id(b.getPublisher_id());
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
}
