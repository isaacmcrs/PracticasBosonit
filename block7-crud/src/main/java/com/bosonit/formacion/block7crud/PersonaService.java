package com.bosonit.formacion.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona agregarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona modificarPersona(String nombre, Persona persona) throws NotFoundExceptions{
        Optional<Persona> personaOptional = personaRepository.findByNombre(nombre);
        if (personaOptional.isPresent()) {
            persona.setID(personaOptional.get().getID());
            return personaRepository.save(persona);
        }
        throw new NotFoundExceptions("No se ha ncontrado"); // O manejar de alguna forma el caso en el que la persona no exista
    }

    // Método para borrar una persona por su nombre
    public void borrarPersona(String nombre) {
        Optional<Persona> personaOptional = personaRepository.findByNombre(nombre);
        personaOptional.ifPresent(persona -> personaRepository.delete(persona));
    }

    // Método para obtener una persona por su nombre
    public Persona obtenerPersonaPorNombre(String nombre){
        Optional<Persona> personaOptional = personaRepository.findByNombre(nombre);
        return personaOptional.orElse(null);
    }

    // Método para obtener todas las personas
    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }
}

