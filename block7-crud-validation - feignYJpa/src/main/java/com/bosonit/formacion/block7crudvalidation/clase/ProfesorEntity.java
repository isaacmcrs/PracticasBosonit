package com.bosonit.formacion.block7crudvalidation.clase;

import com.bosonit.formacion.block7crudvalidation.dtos.PersonaSimpleOutputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.ProfesorInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.ProfesorOutputDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profesor")
public class ProfesorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_profesor;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "coments")
    private String coments;

    @Column(name = "branch", nullable = false)
    private String branch;

    @OneToMany(mappedBy = "profesor")
    private List<StudentEntity> students;

    public String getComents() {
        return coments;
    }

    public void setComents(String coments) {
        this.coments = coments;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    public ProfesorEntity(ProfesorInputDTO profesorInputDto) {

    }
    public ProfesorOutputDTO profesortoProfesorOutputDto(){
        return new ProfesorOutputDTO(
                this.id_profesor,
                this.persona,
                this.coments,
                this.branch,
                this.students
        );
    }

    public void setPersona(Persona persona) {
    }
}