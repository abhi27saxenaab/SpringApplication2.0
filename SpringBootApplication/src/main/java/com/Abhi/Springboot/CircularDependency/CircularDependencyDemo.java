package com.Abhi.Springboot.CircularDependency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CircularDependencyDemo {
    public static void main(String[] args) {
        SpringApplication.run(CircularDependencyDemo.class, args);
    }
}

