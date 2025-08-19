package com.BookStore.service.impl;


import com.BookStore.dto.HelloWorldDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    @Value("${app.name}")
    private String appName;


    public String getAppName() {
        return appName;
    }
    public HelloWorldDTO processHelloWorld(HelloWorldDTO dto) {
        // Business logic here
        dto.setName(appName);
        return dto;
    }
}
