package com.bosonit.formacion.block7crudvalidation.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDTO extends PersonaOutputDTO {
    private long id_profesor;
    private long id_persona;
    private String coments;
    private String branch;

    public ProfesorOutputDTO(
            long id_profesor,
            long id_persona,
            String usuario,
            String name,
            String surname,
            String companyEmail,
            String personalEmail,
            String city,
            boolean active,
            Date createdDate,
            String imageUrl,
            Date terminationDate,
            String coments,
            String branch
    ) {
        super(id_persona, usuario, name, surname, companyEmail, personalEmail, city, active, createdDate, imageUrl, terminationDate);
        this.id_profesor = id_profesor;
        this.coments = coments;
        this.branch = branch;
    }
}
