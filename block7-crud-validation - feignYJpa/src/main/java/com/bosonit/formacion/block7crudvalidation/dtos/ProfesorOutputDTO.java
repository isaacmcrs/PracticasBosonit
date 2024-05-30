package com.bosonit.formacion.block7crudvalidation.dtos;


import com.bosonit.formacion.block7crudvalidation.clase.Persona;
import com.bosonit.formacion.block7crudvalidation.clase.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDTO {
    private long id_profesor;
    private Persona persona;
    private String coments;
    private String branch;
    private List<StudentEntity> estudiantes;

    public void setId(long id) {
        this.id_profesor = id;
    }
}

