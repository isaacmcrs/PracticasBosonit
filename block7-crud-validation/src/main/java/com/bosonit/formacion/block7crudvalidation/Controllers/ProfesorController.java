package com.bosonit.formacion.block7crudvalidation.Controllers;

import com.bosonit.formacion.block7crudvalidation.Dtos.ProfesorOutputDTO;
import com.bosonit.formacion.block7crudvalidation.Service.ProfesorService;
import com.bosonit.formacion.block7crudvalidation.exceptions.ProfesorInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<ProfesorOutputDTO> agregarProfesor(@RequestBody ProfesorInputDTO profesorInputDTO) {
        ProfesorOutputDTO profesorOutputDTO = profesorService.agregarProfesor(profesorInputDTO);
        return new ResponseEntity<>(profesorOutputDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorOutputDTO> buscarProfesorPorID(@PathVariable long id) {
        ProfesorOutputDTO profesorOutputDTO = profesorService.buscarProfesorPorID(id);
        return new ResponseEntity<>(profesorOutputDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProfesorOutputDTO>> mostrarTodos() {
        List<ProfesorOutputDTO> profesorOutputDTOs = profesorService.mostrarTodos();
        return new ResponseEntity<>(profesorOutputDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarProfesor(@PathVariable long id) {
        profesorService.borrarProfesor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
