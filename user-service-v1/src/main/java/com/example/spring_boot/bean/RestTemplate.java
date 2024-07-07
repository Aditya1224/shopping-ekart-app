package com.example.spring_boot.bean;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RestTemplate {

    @Bean
    public RestTemplate getRestTemplate (){
        return new RestTemplate();
    }
}
