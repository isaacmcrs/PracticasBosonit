package com.block6personcontrollers.Controller;

import com.block6personcontrollers.Model.Persona;
import com.block6personcontrollers.Service.ServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador1")
public class Controlador1 {

    @Autowired
    private ServicioPersona servicioPersona;

    @GetMapping("/addPersona")
    public Persona addPersona(@RequestParam String nombre, @RequestParam String poblacion, @RequestParam int edad) {
        return servicioPersona.crearPersona(nombre, poblacion, edad);
    }
}
