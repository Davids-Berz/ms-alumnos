package com.mservice.app.alumnos.services;

import com.mservice.app.alumnos.models.repository.IAlumnoRepository;
import com.mservice.commons.alumnos.models.entity.Alumno;
import com.mservice.generic.services.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImpl extends GenericServiceImpl<Alumno, IAlumnoRepository> implements IAlumnoService {

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findByNombreOrApellido(String text) {
        return repository.findByNombreOrApellido(text);
    }
}
