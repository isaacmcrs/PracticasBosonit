package com.bosonit.formacion.block7crudvalidation.controller;
import com.bosonit.formacion.block7crudvalidation.dtos.PersonaInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.PersonaSimpleOutputDTO;
import com.bosonit.formacion.block7crudvalidation.services.PersonaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/{id}")
    public PersonaSimpleOutputDTO buscarPersonaPorId(@PathVariable long id) {
        return personaService.buscarPersonaID(id);
    }

    @GetMapping("/buscar")
    public PersonaSimpleOutputDTO buscarPersonaPorUsuario(@RequestParam String name) {
        return personaService.buscarPersonaPorUsuario(name);
    }

    @GetMapping
    public List<PersonaSimpleOutputDTO> mostrarTodos() {
        return personaService.mostrarTodos();
    }

    @PostMapping
    public PersonaSimpleOutputDTO agregarPersona(@RequestBody PersonaInputDTO personaInputDTO) {
        return personaService.agregarPersona(personaInputDTO);
    }

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable long id) {
        personaService.borrarPersona(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaSimpleOutputDTO> modificarPersona(@PathVariable long id, @RequestBody PersonaInputDTO personaInputDTO) {
        try {
            PersonaSimpleOutputDTO updatedPersona = personaService.modificarPersona(id, personaInputDTO);
            return ResponseEntity.ok(updatedPersona);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}