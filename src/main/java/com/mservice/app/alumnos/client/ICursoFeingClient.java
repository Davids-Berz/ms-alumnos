package com.mservice.app.alumnos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ms-cursos")
public interface ICursoFeingClient {

    @DeleteMapping("/eliminar-alumno/{id}")
    void deleteCursoAlumnoByAlumnoId(@PathVariable Long id);
}
