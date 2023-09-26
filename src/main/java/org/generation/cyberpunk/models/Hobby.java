package org.generation.cyberpunk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
