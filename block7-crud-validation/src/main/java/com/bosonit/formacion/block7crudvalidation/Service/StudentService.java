package com.bosonit.formacion.block7crudvalidation.Service;

import com.bosonit.formacion.block7crudvalidation.Dtos.StudentInputDTO;
import com.bosonit.formacion.block7crudvalidation.Dtos.StudentOutputDTO;

import java.util.List;

public interface StudentService {
    StudentOutputDTO buscarStudentPorID(long id, String outputType);
    List<StudentOutputDTO> mostrarTodos();
    StudentOutputDTO agregarStudent(StudentInputDTO student);
    void borrarStudent(long id);
    void asignarAsignaturas(long studentId, List<Long> asignaturaIds);
    void desasignarAsignaturas(long studentId, List<Long> asignaturaIds);
}

