package com.BookStore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class AlgoController {
    @GetMapping("/integertoroman")
    public void intToRoman(){
        int num=2837;
        int[] values= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanletters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String roman="";
        for(int i=0; i<values.length; i++){
            while( num >= values[i]){
                num = num - values[i];
                roman = roman + romanletters[i];
            }
        }
        System.out.println("===========" + roman);
    }
}
