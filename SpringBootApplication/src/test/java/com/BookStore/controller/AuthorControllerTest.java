package com.BookStore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.BookStore.dto.AuthorRequestDTO;
import com.BookStore.dto.AuthorResponseDTO;
import com.BookStore.entity.Author;
import com.BookStore.service.impl.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@Ignore
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void saveAuthor() throws Exception{
        List<AuthorResponseDTO> a =new ArrayList<>();

        AuthorResponseDTO a1= new AuthorResponseDTO();
        a1.setAuthor_id(1);
        a1.setFirst_name("A");
        a.add(a1);

        Mockito.when(authorService.getAllAuthor()).thenReturn(a);
        AuthorRequestDTO au = new AuthorRequestDTO();
//        authorController.saveAuthor(au);


    }
}
