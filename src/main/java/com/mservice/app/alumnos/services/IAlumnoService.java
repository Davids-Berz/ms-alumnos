package com.mservice.app.alumnos.services;

import com.mservice.commons.alumnos.models.entity.Alumno;
import com.mservice.generic.services.IGenericService;

import java.util.List;

public interface IAlumnoService extends IGenericService<Alumno> {

    List<Alumno> findByNombreOrApellido(String text);
    Iterable<Alumno> findAllById(Iterable<Long> ids);

}
