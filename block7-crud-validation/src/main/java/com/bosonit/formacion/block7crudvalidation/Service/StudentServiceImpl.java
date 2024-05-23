package com.bosonit.formacion.block7crudvalidation.Service;

import com.bosonit.formacion.block7crudvalidation.Dtos.StudentInputDTO;
import com.bosonit.formacion.block7crudvalidation.Dtos.StudentOutputDTO;
import com.bosonit.formacion.block7crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.modles.Asignatura;
import com.bosonit.formacion.block7crudvalidation.modles.Persona;
import com.bosonit.formacion.block7crudvalidation.modles.Student;
import com.bosonit.formacion.block7crudvalidation.repository.AsignaturaRepository;
import com.bosonit.formacion.block7crudvalidation.repository.PersonaRepository;
import com.bosonit.formacion.block7crudvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public StudentOutputDTO buscarStudentPorID(long id, String outputType) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));

        if ("full".equals(outputType)) {
            return student.toFullStudentOutputDto();
        } else {
            return student.toSimpleStudentOutputDto();
        }
    }
    @Override
    public List<StudentOutputDTO> mostrarTodos() {
        List<Student> students = studentRepository.findAll();
        List<StudentOutputDTO> studentOutputDTOs = new ArrayList<>();
        for (Student student : students) {
            studentOutputDTOs.add(student.toSimpleStudentOutputDto());
        }
        return studentOutputDTOs;
    }
    @Override
    public StudentOutputDTO agregarStudent(StudentInputDTO studentInputDTO) {
        Persona persona = personaRepository.findById(studentInputDTO.getId_persona())
                .orElseThrow(() -> new EntityNotFoundException("Persona not found with id: " + studentInputDTO.getId_persona()));



        Student student = new Student(persona, studentInputDTO);
        Student studentAdded = studentRepository.save(student);
        return studentAdded.toSimpleStudentOutputDto();
    }

    @Override
    public void borrarStudent(long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public void asignarAsignaturas(long studentId, List<Long> asignaturaIds) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));

        List<Asignatura> asignaturas = asignaturaRepository.findAllById(asignaturaIds);
        student.getAsignaturas().addAll(asignaturas);
        studentRepository.save(student);
    }

    @Override
    public void desasignarAsignaturas(long studentId, List<Long> asignaturaIds) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));

        List<Asignatura> asignaturas = asignaturaRepository.findAllById(asignaturaIds);
        student.getAsignaturas().removeAll(asignaturas);
        studentRepository.save(student);
    }
}
