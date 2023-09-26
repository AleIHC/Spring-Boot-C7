package org.generation.cyberpunk.services;

import jakarta.transaction.Transactional;
import org.generation.cyberpunk.models.Empleo;
import org.generation.cyberpunk.repositories.EmpleoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmpleoServiceImpl implements EmpleoService {

    @Autowired
    EmpleoRepository empleoRepository;

    @Override
    public Empleo guardarEmpleo(Empleo empleoNuevo) {
        return empleoRepository.save(empleoNuevo);
    }

    @Override
    public List<Empleo> listaEmpleos() {
        return empleoRepository.findAll();
    }


}
