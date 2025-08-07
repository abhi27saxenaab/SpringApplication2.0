package com.BookStore.service;
import com.BookStore.entity.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.BookStore.service.impl.AuthorService;
import com.BookStore.repository.AuthorRepository;
import com.BookStore.dto.AuthorRequestDTO;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AuthorServiceTests {

    @InjectMocks
    AuthorService authorService;

    @Mock
    AuthorRepository authorRepository;

    private static Author author= null;

    public static void init(){
        System.out.println("BeforeAll");
        author = new Author();
        author.setFirst_name("A");
        author.setLast_name("A");
    }
    @BeforeEach
    public void initEachTest(){
        System.out.println("BeforeEach");
    }
    @Test
    @DisplayName("Author Save Successfully")
    void saveAuthorSuccessfully(){
        AuthorRequestDTO a1 = new AuthorRequestDTO();
        a1.setBiography("A");
        a1.setFirst_name("A");
        a1.setLast_name("A");
        Author addedProduct = authorService.saveAuthor(a1);
    }

}
