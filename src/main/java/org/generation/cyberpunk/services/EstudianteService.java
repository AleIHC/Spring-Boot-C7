package org.generation.cyberpunk.services;

import org.generation.cyberpunk.models.Estudiante;

import java.util.List;

//Interfaz para declarar métodos
public interface EstudianteService {

    List<Estudiante> listaDeEstudiantes();

    Estudiante guardarEstudiante(Estudiante estudianteNuevo);

}
