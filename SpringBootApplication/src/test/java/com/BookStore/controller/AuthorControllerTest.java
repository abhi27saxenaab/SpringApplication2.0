package com.BookStore.controller;


import com.BookStore.service.impl.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void saveAuthor() throws Exception{ 
        String output ="Hello World!";
        mockMvc.perform(get("/author/helloworld"))
                .andExpect(status().isOk())
                .andExpect(content().string(output));

    }
}
