package com.mservice.app.alumnos.controllers;

import com.mservice.app.alumnos.models.entity.Alumno;
import com.mservice.app.alumnos.models.repository.IAlumnoRepository;
import com.mservice.app.alumnos.services.IAlumnoService;
import com.mservice.generic.controllers.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController extends GenericController<Alumno, IAlumnoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno,@PathVariable Long id){

        Optional<Alumno> dbAlumno = service.findById(id);

        if (dbAlumno.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Alumno editAlumno = dbAlumno.get();

        editAlumno.setNombre(alumno.getNombre());
        editAlumno.setApellido(alumno.getApellido());
        editAlumno.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(editAlumno));
    }

}













