package org.generation.cyberpunk.controllers;

import org.generation.cyberpunk.models.Empleo;
import org.generation.cyberpunk.services.EmpleoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleo")
public class EmpleoRestController {

    @Autowired
    EmpleoServiceImpl empleoService;

    @PostMapping("/nuevo")
    public Empleo nuevoEmpleo(@RequestBody  Empleo nuevoEmpleo) {
        return empleoService.guardarEmpleo(nuevoEmpleo);
    }

    @GetMapping("/lista")
    public List<Empleo> enlistarEmpleos() {
        return empleoService.listaEmpleos();
    }





}
