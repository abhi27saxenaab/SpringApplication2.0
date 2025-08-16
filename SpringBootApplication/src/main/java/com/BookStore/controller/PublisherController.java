package com.BookStore.controller;

import com.BookStore.dto.PublisherRequestDTO;
import com.BookStore.dto.PublisherResponseDTO;
import com.BookStore.entity.Publisher;
import com.BookStore.service.impl.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    private PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService){
        this.publisherService=publisherService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Publisher>> ListPublisherById(@PathVariable Integer id){
        PublisherResponseDTO publishers=  this.publisherService.getAllPublisherById(id);
        return new ResponseEntity(publishers, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Publisher>> ListAllPublisher(){
        List<PublisherResponseDTO> publishers=  this.publisherService.getAllPublisher();
        return new ResponseEntity(publishers, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Publisher> savePublisher(@RequestBody PublisherRequestDTO u){
        Publisher publisher=  this.publisherService.savePublisher(u);
        return new ResponseEntity(publisher, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Boolean DeletePublisherById(@PathVariable Integer id){
        Boolean isDeleted=  this.publisherService.deletePublisherById(id);
        return isDeleted;
    }
}
