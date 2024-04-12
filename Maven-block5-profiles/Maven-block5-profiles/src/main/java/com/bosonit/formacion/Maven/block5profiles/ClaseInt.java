package com.bosonit.formacion.Maven.block5profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("INT")
public class ClaseInt implements ClaseInterface{
    public ClaseInt()
    {
        System.out.println("Arranco clase1");
    }

    @Override
    public String saluda() {
        return "Soy clase1 de INT";
    }
}
