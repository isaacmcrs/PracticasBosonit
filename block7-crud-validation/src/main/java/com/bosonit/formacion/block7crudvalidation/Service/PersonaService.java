package com.bosonit.formacion.block7crudvalidation.Service;

import com.bosonit.formacion.block7crudvalidation.Dtos.PersonaInputDTO;
import com.bosonit.formacion.block7crudvalidation.Dtos.PersonaOutputDTO;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTO buscarPersonaPorID(long id);
    PersonaOutputDTO buscarPersonaPorNombre(String name);
    List<PersonaOutputDTO> mostrarTodos();
    PersonaOutputDTO agregarPersona(PersonaInputDTO persona);
    void borrarPersona(long id);
}
