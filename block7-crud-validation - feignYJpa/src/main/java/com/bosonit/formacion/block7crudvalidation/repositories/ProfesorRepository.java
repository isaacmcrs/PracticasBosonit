package com.bosonit.formacion.block7crudvalidation.repositories;

import com.bosonit.formacion.block7crudvalidation.clase.Persona;
import com.bosonit.formacion.block7crudvalidation.clase.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository <ProfesorEntity, Long> {

    List<ProfesorEntity> findByPersonaId(long id_Persona);

}
