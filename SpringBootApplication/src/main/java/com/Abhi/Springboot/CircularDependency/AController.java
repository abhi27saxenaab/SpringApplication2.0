package com.Abhi.Springboot.CircularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AController {

    private BController bController;
    public AController(@Lazy BController b){
        this.bController=b;
    }

}
