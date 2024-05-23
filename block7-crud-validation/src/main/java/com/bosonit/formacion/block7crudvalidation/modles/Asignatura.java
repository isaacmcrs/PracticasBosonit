package com.bosonit.formacion.block7crudvalidation.modles;

import com.bosonit.formacion.block7crudvalidation.Dtos.AsignaturaOutputDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_asignatura;

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    private Student student;

    private String asignatura;
    private String coments;

    @Column(nullable = false)
    private Date initial_date;

    private Date finish_date;

    public AsignaturaOutputDTO toAsignaturaOutputDto() {
        return new AsignaturaOutputDTO(
                id_asignatura,
                student.getId_student(),
                asignatura,
                coments,
                initial_date,
                finish_date
        );
    }
}
