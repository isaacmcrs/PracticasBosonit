package com.bosonit.formacion.block7crudvalidation.Service;

import com.bosonit.formacion.block7crudvalidation.repository.PersonaRepository;
import com.bosonit.formacion.block7crudvalidation.exceptions.ProfesorInputDTO;
import com.bosonit.formacion.block7crudvalidation.Dtos.ProfesorOutputDTO;
import com.bosonit.formacion.block7crudvalidation.repository.ProfesorRepository;
import com.bosonit.formacion.block7crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.formacion.block7crudvalidation.modles.Persona;
import com.bosonit.formacion.block7crudvalidation.modles.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public ProfesorOutputDTO agregarProfesor(ProfesorInputDTO profesorInputDTO) {
        Persona persona = personaRepository.findById(profesorInputDTO.getId_persona())
                .orElseThrow(() -> new EntityNotFoundException("Persona not found with id: " + profesorInputDTO.getId_persona()));


        Profesor profesor = new Profesor(profesorInputDTO, persona);
        Profesor profesorAdded = profesorRepository.save(profesor);
        return profesorAdded.toProfesorOutputDto();
    }

    @Override

    public ProfesorOutputDTO buscarProfesorPorID(long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profesor not found with id: " + id));
        return profesor.toProfesorOutputDto();
    }

    @Override
    public List<ProfesorOutputDTO> mostrarTodos() {
        List<Profesor> profesores = profesorRepository.findAll();
        List<ProfesorOutputDTO> profesorOutputDTOs = new ArrayList<>();
        for (Profesor profesor : profesores) {
            profesorOutputDTOs.add(profesor.toProfesorOutputDto());
        }
        return profesorOutputDTOs;
    }

    @Override
    public void borrarProfesor(long id) {
        if (!profesorRepository.existsById(id)) {
            throw new EntityNotFoundException("Profesor not found with id: " + id);
        }
        profesorRepository.deleteById(id);
    }
}
