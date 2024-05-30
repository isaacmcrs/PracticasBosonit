package com.bosonit.formacion.block7crudvalidation.controller;


import com.bosonit.formacion.block7crudvalidation.dtos.ProfesorInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.ProfesorOutputDTO;
import com.bosonit.formacion.block7crudvalidation.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public ProfesorOutputDTO addProfesor(@RequestBody ProfesorInputDTO profesorInputDto) {
        return profesorService.addProfesor(profesorInputDto);
    }

    @GetMapping("/{id}")
    public ProfesorOutputDTO getProfesor(@PathVariable long id) {
        return profesorService.getProfesor(id);
    }

    @GetMapping
    public List<ProfesorOutputDTO> getAllProfesores() {
        return profesorService.getAllProfesores();
    }

    @PutMapping("/{id}")
    public ProfesorOutputDTO updateProfesor(@PathVariable long id, @RequestBody ProfesorInputDTO profesorInputDto) {
        return profesorService.updateProfesor(id, profesorInputDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProfesor(@PathVariable long id) {
        profesorService.deleteProfesor(id);
    }
}
