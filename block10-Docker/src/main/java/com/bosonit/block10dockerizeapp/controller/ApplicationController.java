package com.bosonit.block10dockerizeapp.controller;

import jakarta.annotation.Resource;
import com.bosonit.block10dockerizeapp.model.Empleado;
import org.springframework.web.bind.annotation.*;
import com.bosonit.block10dockerizeapp.service.EmpleadoServicio;

import java.util.List;

@RestController
@RequestMapping("/postgressApp")
public class                                                                                                                                                                                                                ApplicationController {

    @Resource
    EmpleadoServicio empleadoServicio;

    @GetMapping(value = "/employeeList")
    public List<Empleado> getEmployees() {
        return empleadoServicio.findAll();

    }

    @PostMapping(value = "/createEmp")
    public void meterEmpleado(@RequestBody Empleado emp) {
        empleadoServicio.meterEmpleado(emp);

    }
    @PutMapping(value = "/updateEmp")
    public void modificarEmpleado(@RequestBody Empleado emp) {
        empleadoServicio.modificarEmpleado(emp);

    }
    @PutMapping(value = "/executeUpdateEmp")
    public void EjecutarActualizarEmpleado(@RequestBody Empleado emp) {
        empleadoServicio.EjecutarActualizarEmpleado(emp);

    }

    @DeleteMapping(value = "/deleteEmpById")
    public void borrarEmpleado(@RequestBody Empleado emp) {
        empleadoServicio.borrarEmpleado(emp);

    }


}