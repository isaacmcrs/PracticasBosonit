package com.bosonit.formacion.block7crudvalidation.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaOutputDTOFull implements AsignaturaOutFather {
    private Long id_asignatura;
    private String asignatura;
    private String coments;
    private Date initial_date;
    private Date finish_date;
    private List<EstudianteOutputDTO> estudiantesEntities;
}

