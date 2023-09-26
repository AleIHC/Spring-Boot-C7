package org.generation.cyberpunk.models;

import jakarta.persistence.*;

@Entity
@Table(name = "empleos")
public class Empleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empleoId;

    private String nombrePuesto;

    private Float salario;

    //Anotación para relación de 1 a 1
    @OneToOne
    private Estudiante estudiante;

    public Empleo(Long empleoId, String nombrePuesto, Float salario, Estudiante estudiante) {
        this.empleoId = empleoId;
        this.nombrePuesto = nombrePuesto;
        this.salario = salario;
        this.estudiante = estudiante;
    }

    public Empleo() {
    }

    public Long getEmpleoId() {
        return empleoId;
    }


    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
