package com.mservice.app.alumnos.services;

import com.mservice.app.alumnos.client.ICursoFeingClient;
import com.mservice.app.alumnos.models.repository.IAlumnoRepository;
import com.mservice.commons.alumnos.models.entity.Alumno;
import com.mservice.generic.services.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImpl extends GenericServiceImpl<Alumno, IAlumnoRepository> implements IAlumnoService {

    @Autowired
    private ICursoFeingClient cursoClient;

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findByNombreOrApellido(String text) {
        return repository.findByNombreOrApellido(text);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Alumno> findAllById(Iterable<Long> ids) {
        return repository.findAllById(ids);
    }

    @Override
    @Transactional
    public void deleteCursoAlumnoByAlumnoId(Long id) {
        cursoClient.deleteCursoAlumnoByAlumnoId(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        super.deleteById(id);
        this.deleteCursoAlumnoByAlumnoId(id);
    }
}
