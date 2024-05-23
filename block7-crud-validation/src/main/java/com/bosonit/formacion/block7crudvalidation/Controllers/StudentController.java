package com.bosonit.formacion.block7crudvalidation.Controllers;

import com.bosonit.formacion.block7crudvalidation.Dtos.StudentInputDTO;
import com.bosonit.formacion.block7crudvalidation.Dtos.StudentOutputDTO;
import com.bosonit.formacion.block7crudvalidation.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public StudentOutputDTO buscarStudentPorId(@PathVariable long id,
                                               @RequestParam(defaultValue = "simple") String outputType) {
        return studentService.buscarStudentPorID(id, outputType);
    }

    @GetMapping
    public List<StudentOutputDTO> mostrarTodos() {
        return studentService.mostrarTodos();
    }

    @PostMapping
    public StudentOutputDTO agregarStudent(@RequestBody StudentInputDTO studentInputDTO) {
        return studentService.agregarStudent(studentInputDTO);
    }

    @DeleteMapping("/{id}")
    public void borrarStudent(@PathVariable long id) {
        studentService.borrarStudent(id);
    }

    @PostMapping("/{id}/asignaturas")
    public void asignarAsignaturas(@PathVariable long id, @RequestBody List<Long> asignaturaIds) {
        studentService.asignarAsignaturas(id, asignaturaIds);
    }

    @DeleteMapping("/{id}/asignaturas")
    public void desasignarAsignaturas(@PathVariable long id, @RequestBody List<Long> asignaturaIds) {
        studentService.desasignarAsignaturas(id, asignaturaIds);
    }
}
