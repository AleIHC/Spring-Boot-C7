package org.generation.cyberpunk.services;

import org.generation.cyberpunk.models.Empleo;
import org.generation.cyberpunk.repositories.EmpleoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface EmpleoService {

    Empleo guardarEmpleo(Empleo empleoNuevo);


    List<Empleo> listaEmpleos();

}
