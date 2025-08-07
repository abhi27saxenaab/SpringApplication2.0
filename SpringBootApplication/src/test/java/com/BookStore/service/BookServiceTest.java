package com.BookStore.service;

import com.BookStore.dto.BookRequestDTO;
import com.BookStore.entity.Book;
import com.BookStore.repository.BookRepository;
import com.BookStore.service.impl.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {



    @Mock
    private BookRepository bookRepository; //

    @InjectMocks
    private BookService bookService;

    @Test
    void saveBookShouldAddSuccessfully(){
        BookRequestDTO bookdto = new BookRequestDTO();
        bookdto.setAuthorId(1);
        bookdto.setTitle("test");
        bookdto.setIsbn("111");

        Book expectedBook = new Book();
        expectedBook.setBookId(1);
        expectedBook.setTitle("test");
        expectedBook.setIsbn("111");
        expectedBook.setAuthorId(1);

        // Define mock behavior
        when(bookRepository.save(any(Book.class))).thenReturn(expectedBook);



        Book actualBook = bookService.saveBook(bookdto);

        assertNotNull(actualBook);
        assertEquals("test", actualBook.getTitle());
        assertEquals("111", actualBook.getIsbn());
        assertEquals(1, actualBook.getAuthorId());




    }
}
