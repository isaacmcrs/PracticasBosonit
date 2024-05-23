package com.bosonit.formacion.block7crudvalidation.modles;

import com.bosonit.formacion.block7crudvalidation.exceptions.ProfesorInputDTO;
import com.bosonit.formacion.block7crudvalidation.Dtos.ProfesorOutputDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Profesores")
public class Profesor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn
    private Persona persona;

    @Column(nullable = false)
    private String coments;

    @Column(nullable = false)
    private String branch;

    public Profesor(ProfesorInputDTO profesorInputDTO, Persona persona) {
        this.persona = persona;
        this.coments = profesorInputDTO.getComents();
        this.branch = profesorInputDTO.getBranch();
    }

    public ProfesorOutputDTO toProfesorOutputDto() {
        return new ProfesorOutputDTO(
                this.id,  // ID del profesor
                this.persona.getId(),  // ID de la persona
                this.persona.getUsuario(),  // Usuario de la persona
                this.persona.getName(),  // Nombre de la persona
                this.persona.getSurname(),  // Apellido de la persona
                this.persona.getCompanyEmail(),  // Correo de la empresa de la persona
                this.persona.getPersonalEmail(),  // Correo personal de la persona
                this.persona.getCity(),  // Ciudad de la persona
                this.persona.isActive(),  // Estado activo de la persona
                this.persona.getCreatedDate(),  // Fecha de creación de la persona
                this.persona.getImageUrl(),  // URL de imagen de la persona
                this.persona.getTerminationDate(),  // Fecha de terminación de la persona
                this.coments,  // Comentarios del profesor
                this.branch  // Rama del profesor
        );
    }

}

