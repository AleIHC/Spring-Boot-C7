package org.generation.cyberpunk.services;

import org.generation.cyberpunk.models.Estudiante;

import java.util.List;

//Interfaz para declarar métodos
public interface EstudianteService {

    List<Estudiante> listaDeEstudiantes();

    Estudiante buscarEstudiantePorId(Long id);

    Estudiante guardarEstudiante(Estudiante estudianteNuevo);

    void borrarEstudiante(Long id);



    Estudiante editarEstudiantePorId(Long id, Estudiante estudianteActualizado);

}
