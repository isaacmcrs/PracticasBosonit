package com.bosonit.formacion.block7crudvalidation.Service;

import com.bosonit.formacion.block7crudvalidation.Dtos.PersonaInputDTO;
import com.bosonit.formacion.block7crudvalidation.Dtos.PersonaOutputDTO;
import com.bosonit.formacion.block7crudvalidation.repository.PersonaRepository;
import com.bosonit.formacion.block7crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.formacion.block7crudvalidation.modles.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override

    public PersonaOutputDTO buscarPersonaPorID(long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Persona not found with id: " + id))
                .toPersonaOutputDto();
    }

    @Override

    public PersonaOutputDTO buscarPersonaPorNombre(String name) {
        return personaRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Persona not found with name: " + name))
                .toPersonaOutputDto();
    }

    @Override

    public List<PersonaOutputDTO> mostrarTodos() {
        List<Persona> personas = personaRepository.findAll();
        List<PersonaOutputDTO> personasOutput = new ArrayList<>();
        for (Persona persona : personas) {
            personasOutput.add(persona.toPersonaOutputDto());
        }
        return personasOutput;
    }

    @Override

    public PersonaOutputDTO agregarPersona(PersonaInputDTO personaInputDTO) {
        validarPersona(personaInputDTO);
        Persona persona = new Persona(personaInputDTO);
        Persona personaAgregada = personaRepository.save(persona);
        return personaAgregada.toPersonaOutputDto();
    }

    @Override

    public void borrarPersona(long id) {
        if (!personaRepository.existsById(id)) {
            throw new EntityNotFoundException("Persona not found with id: " + id);
        }
        personaRepository.deleteById(id);
    }

    private void validarPersona(PersonaInputDTO persona) {
        if (persona.getUsuario() == null) {
            throw new UnprocessableEntityException("Usuario no puede ser nulo.");
        }
        if (persona.getUsuario().length() < 6 || persona.getUsuario().length() > 10) {
            throw new UnprocessableEntityException("Longitud de usuario debe estar entre 6 y 10 caracteres.");
        }
        if (persona.getPassword() == null) {
            throw new UnprocessableEntityException("Password no puede ser nulo.");
        }
        if (persona.getName() == null) {
            throw new UnprocessableEntityException("Name no puede ser nulo.");
        }
        if (persona.getCompanyEmail() == null) {
            throw new UnprocessableEntityException("Company Email no puede ser nulo.");
        }
        if (persona.getPersonalEmail() == null) {
            throw new UnprocessableEntityException("Personal Email no puede ser nulo.");
        }
        if (persona.getCity() == null) {
            throw new UnprocessableEntityException("City no puede ser nulo.");
        }
        if (persona.getCreatedDate() == null) {
            throw new UnprocessableEntityException("Created Date no puede ser nulo.");
        }
    }
}
