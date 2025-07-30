package com.jts.SpringBootApplication;

import com.jts.starter.CustomRestClient;
import com.jts.starter.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomStarterController {
    private final CustomRestClient restClient;

    public CustomStarterController(CustomRestClient restClient){
        this.restClient = restClient;
    }

    @GetMapping("/findALl")
    public List<Todo> findAll(){
        return restClient.findAll();
    }
    

}
