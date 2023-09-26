package org.generation.cyberpunk.controllers;

import org.generation.cyberpunk.models.Curso;
import org.generation.cyberpunk.services.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoRestController {

    @Autowired
    CursoServiceImpl cursoService;


    @PostMapping("/nuevo")
    public Curso crearCurso(@RequestBody Curso nuevoCurso) {
        return cursoService.crearCurso(nuevoCurso);
    }

    @GetMapping("/lista")
    public List<Curso> enlistarCursos() {
        return cursoService.enlistarCursos();
    }
}
