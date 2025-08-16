package com.BookStore.controller;

import com.BookStore.dto.PublisherRequestDTO;
import com.BookStore.dto.PublisherResponseDTO;
import com.BookStore.entity.Publisher;
import com.BookStore.exception.ErrorResponse;
import com.BookStore.exception.PublisherNotFound;
import com.BookStore.service.impl.PublisherService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public ResponseEntity<?> ListPublisherById(@PathVariable Integer id){

            Publisher publishers = this.publisherService.getAllPublisherById(id);
            return new ResponseEntity<>(publishers, HttpStatus.OK);


    }
    @Timed
    @GetMapping
    public List<PublisherResponseDTO>ListAllPublisher(){
        List<PublisherResponseDTO> publishers=  this.publisherService.getAllPublisher();
        return publishers;
    }
    @PostMapping
    public Publisher savePublisher(@RequestBody PublisherRequestDTO u){
        Publisher publisher=  this.publisherService.savePublisher(u);
        return publisher;
    }
    @DeleteMapping("/{id}")
    public Boolean DeletePublisherById(@PathVariable Integer id){
        Boolean isDeleted=  this.publisherService.deletePublisherById(id);
        return isDeleted;
    }


}
