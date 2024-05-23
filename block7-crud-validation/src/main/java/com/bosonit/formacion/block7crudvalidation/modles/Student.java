package com.bosonit.formacion.block7crudvalidation.modles;

import com.bosonit.formacion.block7crudvalidation.Dtos.StudentInputDTO;
import com.bosonit.formacion.block7crudvalidation.Dtos.StudentOutputDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_student;

    @OneToOne

    private Persona persona;

    @Column(nullable = false)
    private int num_hours_week;

    private String coments;

    @ManyToOne
   // @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor") // Corrige aquí
    private Profesor profesor;

    @Column(nullable = false)
    private String branch;

    @OneToMany(mappedBy = "student")
    private List<Asignatura> asignaturas;

    public Student(Persona persona, StudentInputDTO studentInputDTO) {
        this.persona = persona;
        this.num_hours_week = studentInputDTO.getNum_hours_week();
        this.coments = studentInputDTO.getComents();
        this.branch = studentInputDTO.getBranch();
    }

    public StudentOutputDTO toSimpleStudentOutputDto() {
        return new StudentOutputDTO(
                id_student,
                num_hours_week,
                coments,
                persona.getId(),
                persona.getUsuario(),
                persona.getPassword(),
                persona.getName(),
                persona.getSurname(),
                persona.getCompanyEmail(),
                persona.getPersonalEmail(),
                persona.getCity(),
                persona.isActive(),
                persona.getCreatedDate(),
                persona.getImageUrl(),
                persona.getTerminationDate()
        );
    }

    public StudentOutputDTO toFullStudentOutputDto() {
        StudentOutputDTO dto = toSimpleStudentOutputDto();
        // Aquí puedes agregar lógica adicional si es necesario para el tipo de salida 'full'
        return dto;
    }
}
