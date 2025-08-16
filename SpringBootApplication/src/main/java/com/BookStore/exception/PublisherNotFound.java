package com.BookStore.exception;

public class PublisherNotFound extends RuntimeException{
    public PublisherNotFound(String message) {
        super(message);
    }
}
