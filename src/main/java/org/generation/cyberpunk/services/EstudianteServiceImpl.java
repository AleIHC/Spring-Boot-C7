package org.generation.cyberpunk.services;

import jakarta.transaction.Transactional;
import org.generation.cyberpunk.models.Estudiante;
import org.generation.cyberpunk.repositories.CursoRepository;
import org.generation.cyberpunk.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Acá definimos la lógica de negocio
@Service
@Transactional
public class EstudianteServiceImpl implements EstudianteService {

    //Inyección de dependencias
    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    CursoRepository cursoRepository;

    //Método para traer una lista de todos los registros
    @Override
    public List<Estudiante> listaDeEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante buscarEstudiantePorId(Long id) {
        Boolean existe = estudianteRepository.existsById(id);

        if (existe) {
            //Optional es una clase que no es el objeto en sí, para obtener el objeto hay otro método
            Estudiante estudianteEscogido = estudianteRepository.findById(id).get();
            return estudianteEscogido;
        } else {
            System.out.println("El id es inválido o no existe");
            return null;
        }
    }

    //El método para guardar un nuevo registro
    @Override
    public Estudiante guardarEstudiante(Estudiante estudianteNuevo){
        //Verificar si es que cumple con la mayoría de edad
            if (estudianteNuevo.getEstudianteEdad() < 18) {
                System.out.println("El estudiante debe ser mayor a 18 años");
                return null;
            } else {
                //Long curso_id = 1L;
                //estudianteNuevo.setCurso(cursoRepository.findById(curso_id).get());
                return estudianteRepository.save(estudianteNuevo);
            }
        }

    //Método para borrar según el id, va a llamar al repository
    @Override
    public void borrarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Estudiante editarEstudiantePorId(Long id, Estudiante estudianteActualizado) {
        Boolean existe = estudianteRepository.existsById(id);

        if (existe) {
            //Buscamos al estudiante en la bdd por su id y lo guardamos en una variable
            Estudiante estudianteSeleccionado = estudianteRepository.findById(id).get();
            //Luego, le vamos seteando cada campo nuevo, obteniéndolo de estudianteActualizado
            estudianteSeleccionado.setEstudianteEdad(estudianteActualizado.getEstudianteEdad());
            estudianteSeleccionado.setEstudianteNombre(estudianteActualizado.getEstudianteNombre());
            estudianteSeleccionado.setEmail(estudianteActualizado.getEmail());
            System.out.println("El estudiante ha sido actualizado");
            return estudianteRepository.save(estudianteSeleccionado);
        } else {
            System.out.println("El estudiante no existe o el id es inválido");
            return null;
        }
    }

    public Estudiante buscarEstudiantePorNombre(String nombre) {
        Estudiante estudiantePorNombre = estudianteRepository.findEstudianteByEstudianteNombre(nombre);
        return estudiantePorNombre;
    }

    public List<Estudiante> buscarEstudiantesPorCurso(String cursoNombre) {
        List<Estudiante> estudiantesCurso = estudianteRepository.findAllByNombreCurso(cursoNombre);
        return estudiantesCurso;
    }



}
