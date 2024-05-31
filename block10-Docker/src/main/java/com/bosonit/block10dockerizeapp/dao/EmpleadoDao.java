package com.bosonit.block10dockerizeapp.dao;

import com.bosonit.block10dockerizeapp.model.Empleado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpleadoDao {
    List<Empleado> findAll();

    void meterEmpleado(Empleado emp);

    void modificarEmpleado(Empleado emp);

    void EjecutarActualizarEmpleado(Empleado emp);

    public void borrarEmpleado(Empleado emp);
}

