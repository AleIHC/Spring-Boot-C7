package org.generation.cyberpunk.controllers;

import org.generation.cyberpunk.models.Estudiante;
import org.generation.cyberpunk.services.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



//Permite indicar la ruta, en este caso es la ruta base para los estudiantes
@Controller
public class EstudianteController {

    /** GET
     * POST
     * PUT
     * DELETE
     * PATCH
     * */

    @Autowired
    EstudianteServiceImpl estudianteService;

    //RequestMapping permite hacer todo tipo de peticiones
    @RequestMapping(value = "/estudiantes", method = RequestMethod.GET)
    public String enlistarEstudiantes(Model model) {
        List<Estudiante> listaEstudiantes = estudianteService.listaDeEstudiantes();
        model.addAttribute("estudiantes", listaEstudiantes);
        return "estudiantes";
    }

    //Controlador para la vista del registro
    @GetMapping("/registro")
    public String mostrarFormulario(Model model) {//Model sirve para mapear algún objeto a la vista que estemos manejando
        model.addAttribute("estudiante", new Estudiante());
        return "registro";
    }

    //Controlador se va a encargar de guardar
    @PostMapping("/nuevo")
    public String guardarEstudiante(@ModelAttribute Estudiante nuevoEstudiante) {
        //Va a llamar al service y al método de guardar estudiante
        estudianteService.guardarEstudiante(nuevoEstudiante);
        return "redirect:/estudiantes";
    }

    //Controlador que se va a encargar de borrar por id
    @PostMapping("/borrar/{id}")
    public String borrarEstudiantePorId(@PathVariable Long id) {
        estudianteService.borrarEstudiante(id);
        return"redirect:/estudiantes";
    }

    //



}