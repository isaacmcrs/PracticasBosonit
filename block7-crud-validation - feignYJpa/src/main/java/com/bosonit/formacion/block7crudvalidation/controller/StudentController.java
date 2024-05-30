package com.bosonit.formacion.block7crudvalidation.controller;
import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaOutputDTOFull;
import com.bosonit.formacion.block7crudvalidation.dtos.EstudianteInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.EstudianteOutputDTO;
import com.bosonit.formacion.block7crudvalidation.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


    @RestController
    @RequestMapping("/students")
    public class StudentController {

        @Autowired
        private StudentService studentService;

        @GetMapping("/{id}")
        public ResponseEntity<EstudianteOutputDTO> getStudentById(@PathVariable long id) {
            try {
                EstudianteOutputDTO student = studentService.getStudentById(id);
                return new ResponseEntity<>(student, HttpStatus.OK);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping
        public ResponseEntity<EstudianteOutputDTO> addStudent(@RequestBody EstudianteInputDTO studentInputDto) {
            EstudianteOutputDTO newStudent = studentService.addStudent(studentInputDto);
            return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<EstudianteOutputDTO>> getAllStudents() {
            List<EstudianteOutputDTO> students = studentService.getAllStudents();
            return new ResponseEntity<>(students, HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<EstudianteOutputDTO> updateStudent(@PathVariable long id, @RequestBody EstudianteInputDTO studentInputDto) {
            try {
                EstudianteOutputDTO updatedStudent = studentService.updateStudent(id, studentInputDto);
                return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
            try {
                studentService.deleteStudent(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping("/{idEstudiante}/asignaturas")
        public ResponseEntity<EstudianteOutputDTO> asignarAsignatura(@RequestBody List<Long> idAsignatura, @PathVariable long idEstudiante) {
            try {
                EstudianteOutputDTO student = studentService.asignarAsignatura(idAsignatura, idEstudiante);
                return new ResponseEntity<>(student, HttpStatus.OK);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/{idEstudiante}/asignaturas")
        public ResponseEntity<EstudianteOutputDTO> desasignarAsignaturas(@RequestBody List<Long> idAsignaturas, @PathVariable long idEstudiante) {
            try {
                EstudianteOutputDTO student = studentService.desasignarAsignaturas(idAsignaturas, idEstudiante);
                return new ResponseEntity<>(student, HttpStatus.OK);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @GetMapping("/{idEstudiante}/asignaturas")
        public ResponseEntity<List<AsignaturaOutputDTOFull>> getAsignaturasByStudentId(@PathVariable long id_Estudiante) {
            List<AsignaturaOutputDTOFull> asignaturas = studentService.getAsignaturasByStudentId(id_Estudiante);
            return new ResponseEntity<>(asignaturas, HttpStatus.OK);
        }

        @DeleteMapping("/asignaturas/{idAsignatura}")
        public ResponseEntity<Void> deleteAsignatura(@PathVariable long idAsignatura) {
            try {
                boolean deleted = studentService.deleteAsignatura(idAsignatura);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }

