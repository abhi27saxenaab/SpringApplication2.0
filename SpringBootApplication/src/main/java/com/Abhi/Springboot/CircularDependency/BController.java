package com.Abhi.Springboot.CircularDependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BController {
    private AController aController;
    public BController(@Lazy AController a){
        this.aController=a;
    }
}
