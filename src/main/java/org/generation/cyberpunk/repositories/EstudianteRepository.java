package org.generation.cyberpunk.repositories;

import org.generation.cyberpunk.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//El repository es la capa que se va a estar comunicando con la bdd
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    //Es una interfaz porque acá sólo se declaran métodos

    //Método para buscar estudiante por el nombre
    //Cuando estamos trabajando con el mismo modelo Jpa ofrece métodos que nos permiten especificar los atributo
    Estudiante findEstudianteByEstudianteNombre(String nombreEstudiante);

    //JPQL
    @Query(value = "select ec.estudiante_id, ec.email, ec.estudiante_edad, ec.nombre, ec.curso_id \n" +
            "from estudiantes_cyberpunk ec\n" +
            "inner join cohortes c \n" +
            "on ec.curso_id  = c.curso_id \n" +
            "where c.nombre = ?1", nativeQuery = true)
    List<Estudiante> findAllByNombreCurso(String cursoNombre);





}