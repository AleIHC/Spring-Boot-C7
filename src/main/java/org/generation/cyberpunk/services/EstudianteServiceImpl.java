package org.generation.cyberpunk.services;

import org.generation.cyberpunk.models.Estudiante;
import org.generation.cyberpunk.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Acá definimos la lógica de negocio
@Service
public class EstudianteServiceImpl implements EstudianteService {

    //Inyección de dependencias
    @Autowired
    EstudianteRepository estudianteRepository;

    //Método para traer una lista de todos los registros
    @Override
    public List<Estudiante> listaDeEstudiantes() {
        return estudianteRepository.findAll();
    }

    //El método para guardar un nuevo registro
    @Override
    public Estudiante guardarEstudiante(Estudiante estudianteNuevo){
        //Verificar si es que el estudiante existe
        if (estudianteRepository.existsById(estudianteNuevo.getEstudianteId())) {
            System.out.println("El estudiante ya existe");
            return null;
        } else {
            if (estudianteNuevo.getEstudianteEdad() < 18) {
                System.out.println("El estudiante debe ser mayor a 18 años");
                return null;
            } else {
                return estudianteRepository.save(estudianteNuevo);
            }
        }
    }
}
