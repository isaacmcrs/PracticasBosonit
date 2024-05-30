package com.bosonit.formacion.block7crudvalidation.dtos;

import com.bosonit.formacion.block7crudvalidation.clase.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorInputDTO {
    private long id_profesor;
    private long id_persona;
    private String coments;
    private String branch;

    @Getter
    private List<StudentEntity> estudiantes;
}