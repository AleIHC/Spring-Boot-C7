package org.generation.cyberpunk.controllers;

import org.generation.cyberpunk.models.Estudiante;
import org.generation.cyberpunk.services.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controlador que sigue patrón REST
@RestController
@RequestMapping("/api")//La ruta base
public class EstudianteRestController {

    @Autowired
    EstudianteServiceImpl estudianteService;

    @GetMapping("/lista")
    public List<Estudiante> listaEstudiantes() {
        //return estudianteService.listaDeEstudiantes();
        List<Estudiante> listaMostrar = estudianteService.listaDeEstudiantes();
        return listaMostrar;

    }

    //Buscar por id
    @GetMapping("/estudiante/{id}")//localhost:8080/api/estudiante/borrar/2
    public Estudiante estudiantePorId(@PathVariable Long id) {
        Estudiante estudianteMostrar = estudianteService.buscarEstudiantePorId(id);
        return estudianteMostrar;
    }

    //Crear nuevo estudiante
    @PostMapping("/estudiante/nuevo")
    public Estudiante guardarNuevoEstudiante(@RequestBody Estudiante estudianteNuevo) {//@RequestBody nos permite enviar un objeto en formato JSON
        Estudiante estudianteParaGuardar = estudianteService.guardarEstudiante(estudianteNuevo);
        return estudianteParaGuardar;
    }

    //Para borrar
    @DeleteMapping("/estudiante/borrar")//localhost:8080/api/estudiante/borrar?id=2
    public String borrarEstudiantePorId(@RequestParam Long id) {
        estudianteService.borrarEstudiante(id);
        return "El estudiante ha sido borrado";
    }

    //Para editar
    @PutMapping("/estudiante/editar/{id}")
    public Estudiante editarEstudiantePorId(@PathVariable Long id,
                                            @RequestBody Estudiante estudianteActualizado) {
        Estudiante estudianteEditado = estudianteService.editarEstudiantePorId(id,
                estudianteActualizado);

        return estudianteEditado;
    }

    //Para traer un estudiante por nombre
    @GetMapping("/estudiante/nombre/{nombre}")
    public Estudiante buscarPorNombre(@PathVariable String nombre) {
        Estudiante estudianteElegido = estudianteService.buscarEstudiantePorNombre(nombre);
        System.out.println(estudianteElegido);
        return estudianteElegido;
    }

    //
    @GetMapping("/estudiante/lista/{curso}")
    public List<Estudiante> enlistarPorCurso(@PathVariable String curso) {
        List<Estudiante> listaEstudiantesCurso = estudianteService.buscarEstudiantesPorCurso(curso);
        System.out.println(listaEstudiantesCurso);
        return listaEstudiantesCurso;
    }


}
