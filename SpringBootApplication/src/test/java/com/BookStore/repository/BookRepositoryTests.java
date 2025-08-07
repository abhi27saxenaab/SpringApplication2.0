package com.BookStore.repository;

import com.BookStore.entity.Book;
import com.BookStore.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureTestDatabase(connection =  EmbeddedDatabaseConnection.H2)
@DataJpaTest
public class BookRepositoryTests {
    @Autowired
    BookRepository bookRepository;

    @Test
    @DisplayName("Should Save Book")
    void SaveAll() {
        Book b1 = new Book();
        b1.setTitle("A");
        b1.setAuthorId(1);
        b1.setIsbn("123");
        Book addedBook = bookRepository.save(b1);
        Assertions.assertThat(addedBook.getBookId()).isGreaterThan(0);
        System.out.println(b1);
    }
    @Test
    @DisplayName("Should Get All Books")
    void GetAllBooks(){
        Book b1 = new Book();
        b1.setTitle("A");
        b1.setAuthorId(1);
        b1.setIsbn("123");
        Book b2 = new Book();
        b2.setTitle("B");
        b2.setAuthorId(1);
        b2.setIsbn("124");
        bookRepository.save(b1);
        bookRepository.save(b2);
        List<Book> books = bookRepository.findAll();
        Assertions.assertThat(books.size()).isGreaterThan(0);
        assertEquals(2,books.size());
    }
    @Test
    @DisplayName("Should find all books")
    void findAllBooks() {

        Book b1 = Book.builder().title("A").isbn("123").authorId(1).build();
        Book b2 = Book.builder().title("A").isbn("123").authorId(1).build();
        bookRepository.save(b1);
        bookRepository.save(b2);

        List<Book> allBooks = bookRepository.findAll();
        assertEquals(2, allBooks.size());
        assertTrue(allBooks.stream().anyMatch(b -> b.getTitle().equals("A")));
        assertTrue(allBooks.stream().anyMatch(b->b.getTitle().equals("A")));
    }


}
