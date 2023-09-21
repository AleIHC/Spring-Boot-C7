package org.generation.cyberpunk.repositories;

import org.generation.cyberpunk.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//El repository es la capa que se va a estar comunicando con la bdd
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    //Es una interfaz porque acá sólo se declaran métodos

}