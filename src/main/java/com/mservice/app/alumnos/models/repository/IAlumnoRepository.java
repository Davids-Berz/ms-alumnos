package com.mservice.app.alumnos.models.repository;

import com.mservice.commons.alumnos.models.entity.Alumno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAlumnoRepository extends CrudRepository<Alumno, Long > {

    @Query("select a from Alumno a where a.nombre like %?1% or a.apellido like %?1%")
    List<Alumno> findByNombreOrApellido(String text);

}
