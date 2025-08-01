package com.Abhi.Springboot.EnableConfigurationProperties;

public class Application {
    public static void main(String[] args) {
        record Person(String name, String address){};

        Person p1= new Person("A","address1");
        System.out.println(p1.address());

    }
}

