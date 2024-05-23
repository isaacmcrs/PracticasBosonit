package com.bosonit.formacion.block7crudvalidation.Service;

import com.bosonit.formacion.block7crudvalidation.exceptions.ProfesorInputDTO;
import com.bosonit.formacion.block7crudvalidation.Dtos.ProfesorOutputDTO;

import java.util.List;

public interface ProfesorService {
    ProfesorOutputDTO agregarProfesor(ProfesorInputDTO profesorInputDTO);
    ProfesorOutputDTO buscarProfesorPorID(long id);
    List<ProfesorOutputDTO> mostrarTodos();
    void borrarProfesor(long id);
}
