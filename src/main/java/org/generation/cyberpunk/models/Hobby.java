package org.generation.cyberpunk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "hobbies")
@NoArgsConstructor//Nos va a crear el constructor vacío
@AllArgsConstructor//Genera constructor con todos los atributos
@Getter
@Setter
//@Data
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hobbyId;

    private String nombreHobby;

    private String materialHobby;

    private String tiempoHobby;

    //Anotación para relación de muchos a muchos
    @ManyToMany
    @JoinTable(//Anotación para la creación de la tabla relacional
            name = "estudiantes_hobbies",//Indicamos el nombre de la tabla
            joinColumns = @JoinColumn(name = "hobby_id"),//Indicamos la columna que lleva la FK de este modelo
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")//La columna que lleva la FK del otro modelo
    )
    private List<Estudiante> listaEstudiantes;






}
