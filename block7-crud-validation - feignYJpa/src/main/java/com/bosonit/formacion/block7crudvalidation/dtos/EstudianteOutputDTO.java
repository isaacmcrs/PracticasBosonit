package com.bosonit.formacion.block7crudvalidation.dtos;


import com.bosonit.formacion.block7crudvalidation.clase.AsignaturasEntity;
import com.bosonit.formacion.block7crudvalidation.clase.Persona;
import com.bosonit.formacion.block7crudvalidation.clase.ProfesorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteOutputDTO {
    private long idStudent;
    private Persona persona;
    private int numHoursWeek;
    private String coments;
    private ProfesorEntity profesor;
    private String branch;
    private List<AsignaturasEntity> asignaturas;

}
