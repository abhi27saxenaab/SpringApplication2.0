package com.Abhi.Springboot.AsyncAnnotation;

import com.Abhi.Springboot.CircularDependency.CircularDependencyDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsyncAnnotationDemo {

    public static void main(String[] args) {
        @Autowired
        OrderService orderService;

        SpringApplication.run(AsyncAnnotationDemo.class, args);

        orderService.OrderA();
        orderService.OrderB();
        orderService.OrderC();

    }
}
