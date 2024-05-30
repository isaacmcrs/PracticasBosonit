package com.bosonit.formacion.block7crudvalidation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyFeign{
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}