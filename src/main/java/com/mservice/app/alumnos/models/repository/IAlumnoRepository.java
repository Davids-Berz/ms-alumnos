package com.mservice.app.alumnos.models.repository;

import com.mservice.app.alumnos.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface IAlumnoRepository extends CrudRepository<Alumno, Long > {

}
