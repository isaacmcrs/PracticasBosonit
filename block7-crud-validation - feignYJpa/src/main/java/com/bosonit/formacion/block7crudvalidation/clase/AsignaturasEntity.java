package com.bosonit.formacion.block7crudvalidation.clase;

import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaOutputDTOFull;
import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaOutputDTOSimple;
import com.bosonit.formacion.block7crudvalidation.dtos.EstudianteOutputDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EstudianteAsignaturaEntity")
public class AsignaturasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignatura;

    @ManyToMany(mappedBy = "asignaturas")
    private List<StudentEntity> estudiantesEntities;

    private String asignatura;
    private String coments;
    @NonNull
    private Date initial_date;
    private Date finish_date;

    public AsignaturasEntity(AsignaturaInputDTO AsignaturaInput) {
        this.asignatura = AsignaturaInput.getAsignatura();
        this.coments = AsignaturaInput.getComents();
        this.initial_date = AsignaturaInput.getInitial_date();
        this.finish_date = AsignaturaInput.getFinish_date();
    }

    public AsignaturaOutputDTOSimple parseAsignaturaOutputSimple() {
        AsignaturaOutputDTOSimple AsignaturaOutPutSimple = new AsignaturaOutputDTOSimple();

        AsignaturaOutPutSimple.setId_asignatura(this.id_asignatura);
        AsignaturaOutPutSimple.setAsignatura(this.asignatura);
        AsignaturaOutPutSimple.setComents(this.coments);
        AsignaturaOutPutSimple.setInitial_date(this.initial_date);
        AsignaturaOutPutSimple.setFinish_date(this.finish_date);
        return AsignaturaOutPutSimple;
    }

    public AsignaturaOutputDTOFull parseAsignaturaOutputFull() {
        AsignaturaOutputDTOFull AsignaturaOutPutFull = new AsignaturaOutputDTOFull();

        AsignaturaOutPutFull.setId_asignatura(this.id_asignatura);
        AsignaturaOutPutFull.setAsignatura(this.asignatura);
        AsignaturaOutPutFull.setComents(this.coments);
        AsignaturaOutPutFull.setInitial_date(this.initial_date);
        AsignaturaOutPutFull.setFinish_date(this.finish_date);
        AsignaturaOutPutFull.setEstudiantesEntities(convertirLista());
        return AsignaturaOutPutFull;
    }

    public List<EstudianteOutputDTO> convertirLista() {
        List<EstudianteOutputDTO> estudianteOutPutSimples = new ArrayList<>();

        if (estudiantesEntities != null) {
            for (StudentEntity estudianteEntity : estudiantesEntities) {
                estudianteOutPutSimples.add(estudianteEntity.studenttoStudentOutpuDto());
            }
        }
        return estudianteOutPutSimples;
    }
}
