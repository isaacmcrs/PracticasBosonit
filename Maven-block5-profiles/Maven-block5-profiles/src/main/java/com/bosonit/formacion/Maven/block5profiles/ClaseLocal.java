package com.bosonit.formacion.Maven.block5profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class ClaseLocal implements ClaseInterface{
    public ClaseLocal()
    {
        System.out.println("Arranco clase de local");
    }

    @Override
    public String saluda() {

        return "Soy clase1 de Local";
    }
}
