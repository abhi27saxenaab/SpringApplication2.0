package com.BookStore;
import org.apache.catalina.filters.RateLimitFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoareApplication {
    public static void main(String[] args) {
        System.out.println("=====" + args[0] + "===" + args[1]);
        SpringApplication.run(BookStoareApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<RateLimitFilter> rateLimiterFilter(){
        FilterRegistrationBean<RateLimitFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RateLimitFilter());
        registrationBean.addUrlPatterns("/hello/*");
        return registrationBean;
    }
}
