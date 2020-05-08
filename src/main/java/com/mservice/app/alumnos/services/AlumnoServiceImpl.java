package com.mservice.app.alumnos.services;

import com.mservice.app.alumnos.models.repository.IAlumnoRepository;
import com.mservice.commons.alumnos.models.entity.Alumno;
import com.mservice.generic.services.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl extends GenericServiceImpl<Alumno, IAlumnoRepository> implements IAlumnoService {


}
