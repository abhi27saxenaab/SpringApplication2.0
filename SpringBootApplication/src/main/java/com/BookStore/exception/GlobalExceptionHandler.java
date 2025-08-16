package com.BookStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PublisherNotFound.class)
    public ResponseEntity<?> handleProductNotFoundException(PublisherNotFound e){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),e.getMessage(),"===!!");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
