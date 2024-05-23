package com.bosonit.formacion.block7crudvalidation.Controllers;

import com.bosonit.formacion.block7crudvalidation.Dtos.PersonaInputDTO;
import com.bosonit.formacion.block7crudvalidation.Dtos.PersonaOutputDTO;
import com.bosonit.formacion.block7crudvalidation.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/{id}")
    public PersonaOutputDTO buscarPersonaPorId(@PathVariable long id) {
        return personaService.buscarPersonaPorID(id);
    }

    @GetMapping("/buscar")
    public PersonaOutputDTO buscarPersonaPorNombre(@RequestParam String name) {
        return personaService.buscarPersonaPorNombre(name);
    }

    @GetMapping
    public List<PersonaOutputDTO> mostrarTodos() {
        return personaService.mostrarTodos();
    }

    @PostMapping
    public PersonaOutputDTO agregarPersona(@RequestBody PersonaInputDTO personaInputDTO) {
        return personaService.agregarPersona(personaInputDTO);
    }

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable long id) {
        personaService.borrarPersona(id);
    }
}
