package com.formacion.Block5properties;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class Clase1 {
    @Value("${greeting}")
    private String greeting;

    @Value("${db.user}")
    private String usuario;


    String saludame()
    {
        return greeting;
    }
    String getUsuario()
    {
        return  usuario;
    }
    @Bean
    @Order(1)
    CommandLineRunner ejectuar2()
    {
        return (args) ->
        {
            System.out.println("SOy el bean 2");

        };
    }
    @PostConstruct
    void afterDead1()
    {
        System.out.println("Me han construido clase1!!!");
    }
}
