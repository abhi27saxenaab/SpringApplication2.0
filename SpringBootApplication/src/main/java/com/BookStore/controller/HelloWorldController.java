package com.BookStore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
public class HelloWorldController {
    @GetMapping("/helloworld")
    public ResponseEntity<String> returnStringWithResponseEntity() {
        return ResponseEntity.ok("Hello World!");
    }
}
