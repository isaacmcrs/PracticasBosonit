package com.formacion.bosonit.Block6;



import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/user/{nombre}")
    public String saludar(@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    @PostMapping("/useradd")
    public Persona agregarUsuario(@RequestBody Persona persona) {
        persona.edad=persona.edad + 1;
        return persona;
    }
}
