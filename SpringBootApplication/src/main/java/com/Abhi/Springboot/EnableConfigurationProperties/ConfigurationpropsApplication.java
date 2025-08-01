package com.Abhi.Springboot.EnableConfigurationProperties;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(MyProperties.class)
@SpringBootApplication
public class ConfigurationpropsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigurationpropsApplication.class, args);
    }
    @Bean
    ApplicationRunner applicationRunner(MyProperties myProperties){
        return args -> {
            System.out.println("=============="+ myProperties.getHost());
            System.out.println("=============="+ myProperties.getPort());
        };
    }

}
