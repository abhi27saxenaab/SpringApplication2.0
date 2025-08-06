package com.jts.SpringBootApplication.repository;

import com.BookStore.entity.Book;
import com.BookStore.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    private Book book1;

    @BeforeEach
    void init() {
        Book book1 = new Book();
        book1.setBookId(1);
        book1.setTitle("A");
        book1.setAuthorId(1);
        book1.setIsbn("123");
    }
    @Test
    @DisplayName("It should return the book list by title")
    void findByBookTitle() {

        List<Book> b1 = bookRepository.findByBookTitle("A");
        System.out.println("===========");
        System.out.println(b1);


    }
}
