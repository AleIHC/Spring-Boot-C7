package org.generation.cyberpunk.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


//Le indicamos que esta es una entidad que debe mapearse a la bdd
@Entity
//Asignar un nombre a la tabla
@Table(name = "estudiantes_cyberpunk")
public class Estudiante {

    @Id//Le indicamos que es la llave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Generar el id de manera auto incrementable
    private Long estudianteId;

    @Column(name = "nombre")//Asignar un nombre a la columna
    @NotNull//Valida que el campo no se deje vacío o null
    //@Size(min = 5, max= 10) valida que el tamaño del string cumpla un mínimo y un máximo
    private String estudianteNombre;

    @Min(value = 18, message = "No se puede ingresar menores de 18")//Viene de la librería jakarta validation, permite indicar un valor mínimo
    @NotNull(message = "Debes ingresar una edad")
    private Integer estudianteEdad;

    @Email(message = "Introdujiste un mail erróneo")//Valida que el campo introducido sea un mail
    @NotNull
    private String email;

    //Constructor vacío y lleno
    public Estudiante() {
    }

    public Estudiante(String estudianteNombre, Integer estudianteEdad, String email) {
        this.estudianteNombre = estudianteNombre;
        this.estudianteEdad = estudianteEdad;
        this.email = email;
    }

    //Accesadores y mutadores
    public Long getEstudianteId() {
        return estudianteId;
    }

    public String getEstudianteNombre() {
        return estudianteNombre;
    }

    public void setEstudianteNombre(String estudianteNombre) {
        this.estudianteNombre = estudianteNombre;
    }

    public Integer getEstudianteEdad() {
        return estudianteEdad;
    }

    public void setEstudianteEdad(Integer estudianteEdad) {
        this.estudianteEdad = estudianteEdad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
