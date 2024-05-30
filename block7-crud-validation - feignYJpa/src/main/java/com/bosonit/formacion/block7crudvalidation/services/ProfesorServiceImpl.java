package com.bosonit.formacion.block7crudvalidation.services;

import com.bosonit.formacion.block7crudvalidation.clase.Persona;
import com.bosonit.formacion.block7crudvalidation.clase.ProfesorEntity;
import com.bosonit.formacion.block7crudvalidation.dtos.ProfesorInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.ProfesorOutputDTO;
import com.bosonit.formacion.block7crudvalidation.exceptions.EntidadNoEncontrada;
import com.bosonit.formacion.block7crudvalidation.repositories.PersonaRepository;
import com.bosonit.formacion.block7crudvalidation.repositories.ProfesorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    private EntidadNoEncontrada entidadNoEncontrada;

    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) {
        Persona persona = personaRepository.findById(profesorInputDTO.getId_persona())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la persona con ID: " + profesorInputDTO.getId_persona()));

        ProfesorEntity profesor = new ProfesorEntity(profesorInputDTO);
        profesor.setPersona(persona);
        return profesorRepository.save(profesor).profesortoProfesorOutputDto();
    }

    @Override
    public ProfesorOutputDTO getProfesor(long id) {
        ProfesorEntity profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el profesor con ID: " + id));
        return profesor.profesortoProfesorOutputDto();
    }

    @Override
    public List<ProfesorOutputDTO> getAllProfesores() {
        return profesorRepository.findAll().stream()
                .map(ProfesorEntity::profesortoProfesorOutputDto)
                .toList();
    }

    @Override
    public ProfesorOutputDTO updateProfesor(long id, ProfesorInputDTO profesorInputDto) {
        ProfesorEntity profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el profesor con ID: " + id));

        profesor.setComents(profesorInputDto.getComents());
        profesor.setBranch(profesorInputDto.getBranch());
        profesor.setStudents(profesorInputDto.getEstudiantes());

        return profesorRepository.save(profesor).profesortoProfesorOutputDto();
    }

    @Override
    public void deleteProfesor(long id) {
        ProfesorEntity profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el profesor con ID: " + id));
        profesorRepository.delete(profesor);
        System.out.println("Se ha borrado el profesor con ID: " + id + " correctamente");
    }
}
