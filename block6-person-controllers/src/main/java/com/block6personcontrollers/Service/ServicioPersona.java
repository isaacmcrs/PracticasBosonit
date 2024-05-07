package com.block6personcontrollers.Service;

import com.block6personcontrollers.Model.Persona;
import org.springframework.stereotype.Service;

@Service
public class ServicioPersona {
    private Persona persona;

    public Persona crearPersona(String nombre, String poblacion, int edad) {
        persona = new Persona(nombre, poblacion, edad);
        return persona;
    }

    public Persona getPersona() {
        return persona;
    }
}
