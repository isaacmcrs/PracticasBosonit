package com.bosonit.formacion.block7crudvalidation.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDTO {
    private long id_persona;
    private int num_hours_week;
    private String coments;
    private String branch;
}
