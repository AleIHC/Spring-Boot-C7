package org.generation.cyberpunk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cohortes")
public class Curso {

    @Id //le indicamos que es la llave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementacion se usa Identity con ID
    private long cursoId;

    @Column(name = "nombre")
    private String cursoNombre;

    @Column(name= "profesor")
    private String cursoProfesor;

    @Column(name= "tema")
    private String cursoTema;

    @Column(name= "anio")
    private Integer cursoFecha;

    //Definimos la relación desde el otro lado
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantesCurso;

    public Curso() {
    }

    public Curso(long cursoId, String cursoNombre, String cursoProfesor, String cursoTema, Integer cursoFecha) {
        this.cursoId = cursoId;
        this.cursoNombre = cursoNombre;
        this.cursoProfesor = cursoProfesor;
        this.cursoTema = cursoTema;
        this.cursoFecha = cursoFecha;
    }

    public long getCursoId() {
        return cursoId;
    }


    public String getCursoNombre() {
        return cursoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    public String getCursoProfesores() {
        return cursoProfesor;
    }

    public void setCursoProfesores(String cursoProfesores) {
        this.cursoProfesor = cursoProfesores;
    }

    public String getCursosTema() {
        return cursoTema;
    }

    public void setCursosTema(String cursosTema) {
        this.cursoTema = cursosTema;
    }

    public Integer getCursosAños() {
        return cursoFecha;
    }

    public void setCursosAños(Integer cursosAños) {
        this.cursoFecha =  cursoFecha;
    }
}
