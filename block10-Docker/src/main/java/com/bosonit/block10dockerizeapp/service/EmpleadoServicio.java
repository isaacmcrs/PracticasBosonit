package com.bosonit.block10dockerizeapp.service;

import com.bosonit.block10dockerizeapp.dao.EmpleadoDao;
import com.bosonit.block10dockerizeapp.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio {

    private final EmpleadoDao employeeDao;

    @Autowired
    public EmpleadoServicio(EmpleadoDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Empleado> findAll() {
        return employeeDao.findAll();
    }

    public void meterEmpleado(Empleado emp) {
        employeeDao.meterEmpleado(emp);
    }

    public void modificarEmpleado(Empleado emp) {
        employeeDao.modificarEmpleado(emp);
    }

    public void EjecutarActualizarEmpleado(Empleado emp) {
        employeeDao.EjecutarActualizarEmpleado(emp);
    }

    public void borrarEmpleado(Empleado emp) {
        employeeDao.borrarEmpleado(emp);
    }
}