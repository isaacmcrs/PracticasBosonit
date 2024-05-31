package com.bosonit.block10dockerizeapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    private String empleadoId;
    private String empleadoNombre;
    private String EmpleadoEmail;
    private String EmpleadoDireccion;

}
