package com.BookStore.controller;


import com.BookStore.service.impl.AuthorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthorController.class)
public class AuthorControllerTests {


    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AuthorService authorService;

    @Test
    public void saveAuthor() throws Exception{
        String output = "Hello World!";
        mockMvc.perform(get("/author/helloworld"))
                .andExpect(status().isOk())
                .andExpect(content().string(output));
    }
}
