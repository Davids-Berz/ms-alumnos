package com.mservice.app.alumnos.controllers;

import com.mservice.app.alumnos.services.IAlumnoService;
import com.mservice.commons.alumnos.models.entity.Alumno;
import com.mservice.generic.controllers.GenericController;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class AlumnoController extends GenericController<Alumno, IAlumnoService> {

    //Ejemplo de programacion reactiva
    @GetMapping("/list")
    Mono list(){
        return  Mono.just(service.findAll());
    }

    @GetMapping("/alumnos-por-curso")
    public ResponseEntity<?> obtenerAlumnosPorCurso(@RequestParam List<Long> ids){
        return ResponseEntity.ok(service.findAllById(ids));
    }


    @GetMapping("/upload/img/{id}")
    public ResponseEntity<?> verFoto(@PathVariable Long id){
        Optional<Alumno> dbAlumno = service.findById(id);

        if (dbAlumno.isEmpty() || dbAlumno.get().getFoto() == null){
            return ResponseEntity.notFound().build();
        }

        Alumno editAlumno = dbAlumno.get();
        Resource imagen = new ByteArrayResource(editAlumno.getFoto());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Alumno alumno, BindingResult result, @PathVariable Long id){

        if(result.hasErrors()){
            return validar(result);
        }
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

    @GetMapping("/filtrar/{text}")
    public ResponseEntity<?> filtrar(@PathVariable String text){
        return ResponseEntity.ok().body(service.findByNombreOrApellido(text));
    }

    @PostMapping("/crear-con-foto")
    public ResponseEntity<?> crearConFoto(@Valid Alumno alumno, BindingResult result,
                                          @RequestParam MultipartFile archivo) throws IOException {

        if(!archivo.isEmpty()){
            alumno.setFoto(archivo.getBytes());
        }

        return super.crear(alumno,result);
    }

    @PutMapping("/editar-con-foto/{id}")
    public ResponseEntity<?> editarConFoto(@Valid Alumno alumno, BindingResult result, @PathVariable Long id,
                                           @RequestParam MultipartFile archivo) throws IOException {

        if(result.hasErrors()){
            return validar(result);
        }
        Optional<Alumno> dbAlumno = service.findById(id);

        if (dbAlumno.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Alumno editAlumno = dbAlumno.get();

        editAlumno.setNombre(alumno.getNombre());
        editAlumno.setApellido(alumno.getApellido());
        editAlumno.setEmail(alumno.getEmail());

        if(!archivo.isEmpty()){
            editAlumno.setFoto(archivo.getBytes());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(editAlumno));
    }
}













