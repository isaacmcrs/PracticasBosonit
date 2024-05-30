package com.bosonit.formacion.block7crudvalidation.services;

import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaOutputDTOFull;
import com.bosonit.formacion.block7crudvalidation.dtos.EstudianteInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.EstudianteOutputDTO;

import java.util.List;

public interface StudentService {
    EstudianteOutputDTO getStudentById(long id);

    EstudianteOutputDTO addStudent(EstudianteInputDTO studentInputDto);

    List<EstudianteOutputDTO> getAllStudents();

    EstudianteOutputDTO updateStudent(long id, EstudianteInputDTO studentInputDto);

    void deleteStudent(long id);

    EstudianteOutputDTO asignarAsignatura(List<Long> idAsignatura, long idEstudiante);
    EstudianteOutputDTO desasignarAsignaturas(List<Long> idAsignaturas, long idEstudiante);

    List<AsignaturaOutputDTOFull> getAsignaturasByStudentId(long idEstudiante);

    boolean deleteAsignatura(long idAsignatura);
}
