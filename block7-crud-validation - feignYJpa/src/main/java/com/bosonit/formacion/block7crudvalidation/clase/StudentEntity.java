package com.bosonit.formacion.block7crudvalidation.clase;

import com.bosonit.formacion.block7crudvalidation.dtos.EstudianteInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.EstudianteOutputDTO;
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
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_student;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "num_hours_week", nullable = false)
    private int numHoursWeek;

    @Column(name = "coments")
    private String coments;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private ProfesorEntity profesor;

    @Column(name = "branch", nullable = false)
    private String branch;

    @ManyToMany
    @JoinTable(
            name = "student_asignaturas",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura")
    )
    private List<AsignaturasEntity> asignaturas;

    public StudentEntity(EstudianteInputDTO studentInputDto) {
        this.id_student = studentInputDto.getIdStudent();
        this.numHoursWeek = studentInputDto.getNumHoursWeek();
        this.coments = studentInputDto.getComents();
        this.profesor = studentInputDto.getProfesor();
        this.branch = studentInputDto.getBranch();
    }

    public EstudianteOutputDTO studenttoStudentOutpuDto() {
        return new EstudianteOutputDTO(
                this.id_student,
                this.persona,
                this.numHoursWeek,
                this.coments,
                this.profesor,
                this.branch,
                this.asignaturas
        );
    }
}
