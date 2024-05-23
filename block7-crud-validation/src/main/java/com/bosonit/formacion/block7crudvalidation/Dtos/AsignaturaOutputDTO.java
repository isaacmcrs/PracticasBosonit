package com.bosonit.formacion.block7crudvalidation.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaOutputDTO {
    private long id_asignatura;
    private long id_student;
    private String asignatura;
    private String coments;
    private Date initial_date;
    private Date finish_date;
}
