package com.bosonit.formacion.block7crudvalidation.services;

import com.bosonit.formacion.block7crudvalidation.clase.AsignaturasEntity;
import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaOutFather;
import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaOutputDTOSimple;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AsignaturaService {

    AsignaturaOutFather buscarAsignatura(long id, String outputType);

    List<AsignaturaOutFather> listarAsignatura(String outputType);

    AsignaturaOutputDTOSimple añadirAsignatura(AsignaturaInputDTO AsignaturaInputdto ) throws Exception;

    void borrarAsignatura(long id);

    AsignaturaOutputDTOSimple updateAsignatura(long id, AsignaturaInputDTO asignaturaInput);


}