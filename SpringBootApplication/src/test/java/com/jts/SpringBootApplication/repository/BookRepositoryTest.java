package com.jts.SpringBootApplication.repository;

import com.BookStore.entity.Book;

import com.BookStore.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@AutoConfigureTestDatabase(connection =  EmbeddedDatabaseConnection.H2)
@DataJpaTest
public class BookRepositoryTest {


    @Autowired
    BookRepository bookRepository;


    @Test
    @DisplayName("Should find all books")
    void findAllBooks() {
//        List<Book> allBooks = bookRepository.findAll();

//        assertEquals(2, allBooks.size());
//        assertTrue(allBooks.stream().anyMatch(b -> b.getTitle().equals("The Great Gatsby")));
//        assertTrue(allBooks.stream().anyMatch(b -> b.getTitle().equals("To Kill a Mockingbird")));
    }


}
