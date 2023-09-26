package org.generation.cyberpunk.services;

import jakarta.transaction.Transactional;
import org.generation.cyberpunk.models.Curso;
import org.generation.cyberpunk.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional//Viene del concepto de transacción
public class CursoServiceImpl implements CursoService{

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public Curso crearCurso(Curso nuevoCurso) {
        return cursoRepository.save(nuevoCurso);
    }

    @Override
    public List<Curso> enlistarCursos() {
        return cursoRepository.findAll();
    }

}
