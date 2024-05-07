package com.bosonit.formacion.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class BorrarPersonaController {

    @Autowired
    private PersonaService personaService;

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> borrarPersona(@PathVariable String nombre) {
        personaService.borrarPersona(nombre);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
