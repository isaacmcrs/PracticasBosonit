
package com.formacion.block5commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SegundaClase implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("Hola desde clase secundaria");
    }
}