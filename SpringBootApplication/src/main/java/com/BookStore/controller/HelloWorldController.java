package com.BookStore.controller;

import com.BookStore.dto.HelloWorldDTO;
import com.BookStore.service.impl.HelloWorldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloService) {
        this.helloWorldService = helloService;
    }


    @GetMapping("/helloworld")
    public ResponseEntity<String> returnStringWithResponseEntity() {
        return ResponseEntity.ok("Hello World!");
    }
    @PostMapping("/hello1")
    public HelloWorldDTO hello1(@RequestBody HelloWorldDTO hello2){

        HashMap<String, Integer> hashMap= new HashMap<>();
        hashMap.put("math",5);
        hashMap.put("science",10);
        hashMap.put("english",11);

        for(Map.Entry<String, Integer> entry:hashMap.entrySet()){
            System.out.println(entry);
        }

        for(String key : hashMap.keySet()){
            System.out.println(key);
        }

        for(Integer value : hashMap.values()){
            System.out.println(value);
        }

        hashMap.forEach((key, value)->{
            System.out.println(key);
        });



        return this.helloWorldService.processHelloWorld(hello2);
    }
}
