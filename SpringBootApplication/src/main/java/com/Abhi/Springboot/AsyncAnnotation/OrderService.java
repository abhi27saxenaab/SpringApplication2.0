package com.Abhi.Springboot.AsyncAnnotation;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void OrderA() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("============OrderA");

    }
    public void OrderB() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("============OrderB");

    }
    public void OrderC() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("============OrderC");

    }
}
