package com.bosonit.formacion.block7crudvalidation.services;
import com.bosonit.formacion.block7crudvalidation.clase.AsignaturasEntity;
import com.bosonit.formacion.block7crudvalidation.clase.StudentEntity;
import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaInputDTO;
import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaOutFather;
import com.bosonit.formacion.block7crudvalidation.dtos.AsignaturaOutputDTOSimple;
import com.bosonit.formacion.block7crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.repositories.AsignaturasRepository;
import com.bosonit.formacion.block7crudvalidation.repositories.StudenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AsignaturaSeviceImpl implements AsignaturaService {

    @Autowired
    private StudenRepository estudianteRepositorio;
    @Autowired
    private AsignaturasRepository AsignaturaRepositorio;

    @Override
    public AsignaturaOutFather buscarAsignatura(long id, String outputType) {
        Optional<AsignaturasEntity> op1 = AsignaturaRepositorio.findById(id);
        AsignaturasEntity asignatura;
        AsignaturaOutFather asignaturaOutFather;

        if (op1.isPresent()) {
            asignatura = op1.get();
            if (outputType.equalsIgnoreCase("full")) {
                asignaturaOutFather = asignatura.parseAsignaturaOutputFull();
                return asignaturaOutFather;
            } else {
                asignaturaOutFather = asignatura.parseAsignaturaOutputSimple();
                return asignaturaOutFather;
            }
        } else {
           throw new EntityNotFoundException( "No existe la asignatura con id: " + id);
        }
    }

    @Override
    public List<AsignaturaOutFather> listarAsignatura(String outputType) {
        List<AsignaturasEntity> AsignaturaEntities = AsignaturaRepositorio.findAll();
        List<AsignaturaOutFather> asignaturaOutFatherList = new ArrayList<>();

        for (AsignaturasEntity asignatura : AsignaturaEntities) {
            if (outputType.equalsIgnoreCase("full")) {
                AsignaturaOutFather asignaturaOutFather = asignatura.parseAsignaturaOutputFull();
                asignaturaOutFatherList.add(asignaturaOutFather);
            } else {
                AsignaturaOutFather asignaturaOutFather = asignatura.parseAsignaturaOutputSimple();
                asignaturaOutFatherList.add(asignaturaOutFather);
            }
        }

        return asignaturaOutFatherList;
    }


    @Override
    public AsignaturaOutputDTOSimple añadirAsignatura(AsignaturaInputDTO AsignaturaInput) throws Exception {
        StudentEntity estudianteEntity = new StudentEntity();
        AsignaturasEntity asignatura = new AsignaturasEntity (AsignaturaInput);
        List<AsignaturasEntity> AsignaturaEntities = new ArrayList<>();
        List<StudentEntity> estudiantes = new ArrayList<>();
        Optional<StudentEntity> op1 = estudianteRepositorio.findById(AsignaturaInput.getId_estudiante());

        if (op1.isPresent()) {
            estudianteEntity = op1.get();
            AsignaturaEntities = estudianteEntity.getAsignaturas();
            AsignaturaEntities.add(asignatura);
            estudianteEntity.setAsignaturas(AsignaturaEntities);

            estudiantes.add(estudianteEntity);
            asignatura.setEstudiantesEntities(estudiantes);
            AsignaturaRepositorio.save(asignatura);
            estudianteRepositorio.save(estudianteEntity);


        } else {
            throw new EntityNotFoundException( "No existe la persona con id: ");
        }

        return asignatura.parseAsignaturaOutputSimple();
    }

    @Override
    public void borrarAsignatura(long id) {
        Optional<AsignaturasEntity> op1 = AsignaturaRepositorio.findById(id);
        AsignaturasEntity AsignaturaEntity;
        List<StudentEntity> esA1;
        List<AsignaturasEntity> asignaturas;

        if (op1.isPresent()){
            AsignaturaEntity= op1.get();


            esA1 = AsignaturaEntity.getEstudiantesEntities();

            for (StudentEntity esA : esA1) {
                asignaturas = esA.getAsignaturas();
                if (asignaturas != null) {
                    asignaturas.removeIf(asignatura -> asignatura.equals(AsignaturaEntity));
                    estudianteRepositorio.save(esA);
                }
            }

        }else{
            throw new jakarta.persistence.EntityNotFoundException("No existe la asignatura con id: " + id);
        }
        AsignaturaEntity.setEstudiantesEntities(null);
        AsignaturaRepositorio.save(AsignaturaEntity);
        AsignaturaRepositorio.deleteById(id);

    }

    @Override
    public AsignaturaOutputDTOSimple updateAsignatura(long id, AsignaturaInputDTO asignaturaInput) {
        Optional<AsignaturasEntity> op1 = AsignaturaRepositorio.findById(id);
        Optional<StudentEntity> op2 = estudianteRepositorio.findById(asignaturaInput.getId_estudiante());
        AsignaturasEntity asignaturaEntity;
        List<AsignaturasEntity> AsignaturaEntities = new ArrayList<>();
        StudentEntity estudianteEntity;
        List<StudentEntity> estudiantes = new ArrayList<>();

        if (op1.isPresent()&&op2.isPresent()) {
            asignaturaEntity = op1.get();
            estudianteEntity = op2.get();

            AsignaturaEntities = estudianteEntity.getAsignaturas();
            estudiantes = asignaturaEntity.getEstudiantesEntities();
            asignaturaEntity.setAsignatura(asignaturaInput.getAsignatura());
            asignaturaEntity.setComents(asignaturaInput.getComents());
            asignaturaEntity.setInitial_date(asignaturaInput.getInitial_date());
            asignaturaEntity.setFinish_date(asignaturaInput.getFinish_date());

            AsignaturaEntities.add(asignaturaEntity);
            estudianteEntity.setAsignaturas(AsignaturaEntities);
            estudiantes.add(estudianteEntity);
            asignaturaEntity.setEstudiantesEntities(estudiantes);
            AsignaturaRepositorio.save(asignaturaEntity);
            AsignaturaRepositorio.save(asignaturaEntity);
            return asignaturaEntity.parseAsignaturaOutputSimple();
        } else {
            throw new EntityNotFoundException("No existe la asignatura con id: " + id);
        }

    }}
