package com.bosonit.formacion.block7crudvalidation.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDTO extends PersonaSimpleOutputDTO {
    EstudianteOutputDTO estudianteOutputDTO;
}

