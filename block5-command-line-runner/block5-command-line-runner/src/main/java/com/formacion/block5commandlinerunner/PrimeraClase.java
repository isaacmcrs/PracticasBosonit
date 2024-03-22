
package com.formacion.block5commandlinerunner ;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PrimeraClase {
    @PostConstruct

    public void ejecutarPostConstruct(){
        System.out.println("Hola desde clase inicial");
    }


}