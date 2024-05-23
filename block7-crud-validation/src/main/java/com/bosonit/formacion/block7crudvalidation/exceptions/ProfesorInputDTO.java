package com.bosonit.formacion.block7crudvalidation.exceptions;

import lombok.Data;

@Data
public class ProfesorInputDTO {
    private long id_persona;
    private String coments;
    private String branch;
}
