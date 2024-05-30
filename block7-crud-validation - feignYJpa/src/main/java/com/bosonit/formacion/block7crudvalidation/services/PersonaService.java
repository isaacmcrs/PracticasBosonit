package com.bosonit.formacion.block7crudvalidation.services;

import com.bosonit.formacion.block7crudvalidation.dtos.PersonaInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.PersonaSimpleOutputDTO;

import java.util.List;

public interface PersonaService {

    PersonaSimpleOutputDTO buscarPersonaID(long id);

    PersonaSimpleOutputDTO buscarPersonaPorUsuario(String name);

    List<PersonaSimpleOutputDTO> mostrarTodos ();

    PersonaSimpleOutputDTO agregarPersona (PersonaInputDTO persona);

    void borrarPersona(long id);

    PersonaSimpleOutputDTO modificarPersona(long id, PersonaInputDTO personaInputDTO);

}
