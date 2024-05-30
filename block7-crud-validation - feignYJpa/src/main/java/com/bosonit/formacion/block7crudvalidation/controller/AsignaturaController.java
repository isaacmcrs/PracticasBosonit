package com.bosonit.formacion.block7crudvalidation.controller;

import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaOutFather;
import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaOutputDTOSimple;
import com.bosonit.formacion.block7crudvalidation.services.AsignaturaSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/Asignaturas")
@RestController
public class AsignaturaController {

    @Autowired
    private AsignaturaSeviceImpl AsignaturaServiceImp;

    @GetMapping("/asignatura/{id}")
    public AsignaturaOutFather buscarAsignatura(@PathVariable("id") Long id, @RequestParam("outputType") String outputType) {
        return AsignaturaServiceImp.buscarAsignatura(id, outputType);
    }

    @GetMapping("/listar")
    public List<AsignaturaOutFather> listarPersonas(@RequestParam("outputType") String outputType) {
        List<AsignaturaOutFather> profesorOutPutFathers;

        if (outputType.equalsIgnoreCase("full")) {
            profesorOutPutFathers = AsignaturaServiceImp.listarAsignatura(outputType);
            return new ArrayList<>(profesorOutPutFathers);
        } else {
            profesorOutPutFathers = AsignaturaServiceImp.listarAsignatura(outputType);
            return new ArrayList<>(profesorOutPutFathers);
        }
    }

    @PostMapping("/agregar")
    public AsignaturaOutputDTOSimple añadirAlumno(@RequestBody AsignaturaInputDTO asignaturaInput) throws Exception {

        return AsignaturaServiceImp.añadirAsignatura(asignaturaInput);
    }
    @DeleteMapping("/asignatura/{id}")
    public void borrarAsignatura(@PathVariable("id") Long id) {
        AsignaturaServiceImp.borrarAsignatura(id);
    }
    @PutMapping("/asignatura/{id}")
    public AsignaturaOutputDTOSimple updateAsignatura(@PathVariable("id") Long id, @RequestBody AsignaturaInputDTO asignaturaInput) {
        return AsignaturaServiceImp.updateAsignatura(id, asignaturaInput);
    }





}