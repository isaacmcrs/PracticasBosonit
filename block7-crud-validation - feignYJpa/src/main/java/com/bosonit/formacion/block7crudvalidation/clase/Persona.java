package com.bosonit.formacion.block7crudvalidation.clase;
import com.bosonit.formacion.block7crudvalidation.dtos.PersonaInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.PersonaSimpleOutputDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_persona;
    @Column(nullable = false,length = 10)
    private String usuario;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String company_email;
    @NotNull
    private String personal_email;
    @NotNull
    private String city;
    @NotNull
    private boolean active;
    @NotNull
    private Date created_date;
    @NotNull
    private String imagen_url;
    @NotNull
    private Date termination_date;



    public Persona (PersonaInputDTO personaInputDto){
        //this.id_persona = Long.valueOf(personaInputDto.getId_persona());
        this.usuario = personaInputDto.getUsuario();
        this.password = personaInputDto.getPassword();
        this.name = personaInputDto.getName();
        this.surname = personaInputDto.getSurname();
        this.company_email = personaInputDto.getCompanyEmail();
        this.personal_email = personaInputDto.getPersonalEmail();
        this.city = personaInputDto.getCity();
        this.active = personaInputDto.isActive();
        this.created_date = personaInputDto.getCreatedDate();
        this.imagen_url = personaInputDto.getImageUrl();
        this.termination_date = personaInputDto.getTerminationDate();
    }


    public PersonaSimpleOutputDTO personatoPersonaOutputDto(){
        return new PersonaSimpleOutputDTO(
                this.id_persona,
                this.usuario,
                this.name,
                this.surname,
                this.company_email,
                this.personal_email,
                this.city,
                this.active,
                this.created_date,
                this.imagen_url,
                this.termination_date
        );
    }
    public long getId() {
        return id_persona;
    }

    public long getIdPersona() {
        return id_persona;
    }



}
