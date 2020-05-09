package com.mservice.app.alumnos.models.repository;

import com.mservice.commons.alumnos.models.entity.Alumno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IAlumnoRepository extends PagingAndSortingRepository<Alumno, Long > {

    @Query("select a from Alumno a where a.nombre like %?1% or a.apellido like %?1%")
    List<Alumno> findByNombreOrApellido(String text);

}
