package com.bosonit.formacion.block7crudvalidation.services;

import com.bosonit.formacion.block7crudvalidation.clase.AsignaturasEntity;
import com.bosonit.formacion.block7crudvalidation.clase.StudentEntity;
import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaOutputDTOFull;
import com.bosonit.formacion.block7crudvalidation.dtos.EstudianteInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.EstudianteOutputDTO;
import com.bosonit.formacion.block7crudvalidation.repositories.AsignaturasRepository;
import com.bosonit.formacion.block7crudvalidation.repositories.StudenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl  implements  StudentService{
    @Autowired
    StudenRepository studentRepository;
    @Autowired
    AsignaturasRepository asignaturaRepository;
    @Override
    public EstudianteOutputDTO getStudentById(long id) {

        return studentRepository.findById(id).get().studenttoStudentOutpuDto();
    }

    @Override
    public EstudianteOutputDTO addStudent(EstudianteInputDTO studentInputDto) {

        return  studentRepository.save(new StudentEntity(studentInputDto)).studenttoStudentOutpuDto();

    }

    @Override
    public List<EstudianteOutputDTO> getAllStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        return students.stream()
                .map(StudentEntity::studenttoStudentOutpuDto)
                .toList();

    }

    @Override
    public EstudianteOutputDTO updateStudent(long id, EstudianteInputDTO studentInputDto) {
         StudentEntity student = studentRepository.findById(id).orElse(null);


        student.setPersona(studentInputDto.getPersona());
        student.setNumHoursWeek(studentInputDto.getNumHoursWeek());
        student.setComents(studentInputDto.getComents());
        student.setProfesor(studentInputDto.getProfesor());
        student.setBranch(studentInputDto.getBranch());

        return studentRepository.save(student).studenttoStudentOutpuDto();

    }


    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public EstudianteOutputDTO asignarAsignatura(List<Long> idAsignatura, long idEstudiante) {
        StudentEntity student = studentRepository.findById(idEstudiante).orElseThrow(() -> new RuntimeException("error"));

        List<AsignaturasEntity> asignaturas = asignaturaRepository.findAllById(idAsignatura);
        student.getAsignaturas().addAll(asignaturas);
        StudentEntity updatedStudent = studentRepository.save(student);
        return updatedStudent.studenttoStudentOutpuDto();

    }

    @Override
    public EstudianteOutputDTO desasignarAsignaturas(List<Long> idAsignaturas, long idEstudiante) {
        StudentEntity student = studentRepository.findById(idEstudiante).orElseThrow(()->new RuntimeException(""));

        List<AsignaturasEntity> asignaturasToRemove = asignaturaRepository.findAllById(idAsignaturas);
        student.getAsignaturas().removeAll(asignaturasToRemove);
        StudentEntity updatedStudent = studentRepository.save(student);
        return updatedStudent.studenttoStudentOutpuDto();
    }

    @Override
    public List<AsignaturaOutputDTOFull> getAsignaturasByStudentId(long idEstudiante) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(idEstudiante);
        if (optionalStudent.isPresent()) {
            StudentEntity student = optionalStudent.get();
            return student.getAsignaturas().stream()
                    .map(AsignaturasEntity::parseAsignaturaOutputFull)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean deleteAsignatura(long idAsignatura) {
        AsignaturasEntity asignatura = asignaturaRepository.findById(idAsignatura).orElse(null);
        if (asignatura != null) {
            if (asignatura.getEstudiantesEntities().isEmpty()) {
                asignaturaRepository.deleteById(idAsignatura);
                return true;
            } else {
                throw new RuntimeException("No se puede eliminar la asignatura porque tiene estudiantes asignados.");
            }
        } else {
            throw new RuntimeException("No se encontró la asignatura con el ID proporcionado.");
        }
    }
}

