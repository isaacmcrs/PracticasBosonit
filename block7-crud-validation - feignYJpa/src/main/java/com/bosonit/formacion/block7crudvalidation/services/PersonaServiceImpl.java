package com.bosonit.formacion.block7crudvalidation.services;
import com.bosonit.formacion.block7crudvalidation.exceptions.EntidadNoEncontrada;
import com.bosonit.formacion.block7crudvalidation.clase.Persona;
import com.bosonit.formacion.block7crudvalidation.dtos.PersonaInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.PersonaSimpleOutputDTO;
import com.bosonit.formacion.block7crudvalidation.repositories.PersonaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private EntidadNoEncontrada entidadNoEncontrada;

    @Autowired
    private PersonaRepository personaRepository;


        public PersonaSimpleOutputDTO buscarPersonaID (long id){
            return personaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("No se encontro la persona con nombre: " + id))
                    .personatoPersonaOutputDto();
        }

        public PersonaSimpleOutputDTO buscarPersonaPorUsuario (String name){
            return personaRepository.findByName(name)
                    .orElseThrow(() -> new EntityNotFoundException("No se encontro la persona con nombre: " + name))
                    .personatoPersonaOutputDto();
        }

        public List<PersonaSimpleOutputDTO> mostrarTodos() {
            List<Persona> personas = personaRepository.findAll();
            List<PersonaSimpleOutputDTO> personasOutput = new ArrayList<>();
            for (Persona persona : personas) {
                personasOutput.add(persona.personatoPersonaOutputDto());
            }
            return personasOutput;
        }


        public PersonaSimpleOutputDTO agregarPersona(PersonaInputDTO personaInputDTO) {
                Persona persona = new Persona(personaInputDTO);
                Persona personaAgregada = personaRepository.save(persona);
                return personaAgregada.personatoPersonaOutputDto();
            }


        public void borrarPersona(long id) {
            Persona persona = personaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("No se encontro la persona con ID: " + id));
            personaRepository.delete(persona);
            System.out.println("Se ha borrado la persona con ID: " + id + " correctamente");
        }

    @Override
    public PersonaSimpleOutputDTO modificarPersona(long id, PersonaInputDTO personaInputDTO) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la persona con ID: " + id));

        persona.setUsuario(personaInputDTO.getUsuario());
        persona.setPassword(personaInputDTO.getPassword());
        persona.setName(personaInputDTO.getName());
        persona.setSurname(personaInputDTO.getSurname());
        persona.setCompany_email(personaInputDTO.getCompanyEmail());
        persona.setPersonal_email(personaInputDTO.getPersonalEmail());
        persona.setCity(personaInputDTO.getCity());
        persona.setActive(personaInputDTO.isActive());
        persona.setCreated_date(personaInputDTO.getCreatedDate());
        persona.setImagen_url(personaInputDTO.getImageUrl());
        persona.setTermination_date(personaInputDTO.getTerminationDate());


        Persona personaActualizada = personaRepository.save(persona);
        return personaActualizada.personatoPersonaOutputDto();
    }

    }

