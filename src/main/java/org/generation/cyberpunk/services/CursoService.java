package org.generation.cyberpunk.services;


import org.generation.cyberpunk.models.Curso;

import java.util.List;

public interface CursoService {

    Curso crearCurso(Curso nuevoCurso);

    List<Curso> enlistarCursos();
}
