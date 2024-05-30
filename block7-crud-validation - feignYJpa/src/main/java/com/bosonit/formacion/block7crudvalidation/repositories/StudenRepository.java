package com.bosonit.formacion.block7crudvalidation.repositories;

import com.bosonit.formacion.block7crudvalidation.clase.ProfesorEntity;
import com.bosonit.formacion.block7crudvalidation.clase.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudenRepository extends JpaRepository <StudentEntity, Long> {
    @Query(value = "SELECT * FROM Student WHERE idAsignatura like %?1%", nativeQuery = true)

    List<StudentEntity> findByPersonaId(long idPersona);
}
