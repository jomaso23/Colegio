package ar.org.centro8.colegio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
	private Integer idCurso;

    
    public Alumno() {
    }


    public Alumno(String nombre, String apellido, Integer edad, Integer idCurso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.idCurso = idCurso;
    }


    public Alumno(Integer id, String nombre, String apellido, Integer edad, Integer idCurso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.idCurso = idCurso;
    }


    @Override
    public String toString() {
        return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", idCurso="
                + idCurso + "]";
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public Integer getEdad() {
        return edad;
    }


    public void setEdad(Integer edad) {
        this.edad = edad;
    }


    public Integer getIdCurso() {
        return idCurso;
    }


    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    

}