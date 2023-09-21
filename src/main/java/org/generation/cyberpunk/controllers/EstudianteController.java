package org.generation.cyberpunk.controllers;

import org.generation.cyberpunk.models.Estudiante;
import org.generation.cyberpunk.services.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Controlador que sigue patrón REST
@RestController
//Permite indicar la ruta, en este caso es la ruta base para los estudiantes
public class EstudianteController {

    /** GET
    * POST
    * PUT
    * DELETE
    * PATCH
    * */

    @Autowired
    EstudianteServiceImpl estudianteService;

    @RequestMapping(value = "/estudiantes", method = RequestMethod.GET)
    public List<Estudiante> enlistarEstudiantes() {
        return estudianteService.listaDeEstudiantes();
    }



}
