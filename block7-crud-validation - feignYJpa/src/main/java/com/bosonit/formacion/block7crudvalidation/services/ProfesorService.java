package com.bosonit.formacion.block7crudvalidation.services;

import com.bosonit.formacion.block7crudvalidation.dtos.ProfesorInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.ProfesorOutputDTO;

import java.util.List;

public interface ProfesorService {
    ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDto);

    ProfesorOutputDTO getProfesor(long id);

    List<ProfesorOutputDTO> getAllProfesores();

    ProfesorOutputDTO updateProfesor(long id, ProfesorInputDTO profesorInputDto);

    void deleteProfesor(long id);
}
