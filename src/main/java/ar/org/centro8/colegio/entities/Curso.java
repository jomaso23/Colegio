package ar.org.centro8.colegio.entities;

import ar.org.centro8.colegio.enums.Dia;
import ar.org.centro8.colegio.enums.Turno;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String titulo;
    private String profesor;
    @Enumerated(value = EnumType.STRING)
    private Dia dia;
	private Turno turno;

    
    public Curso() {
    }


    public Curso(String titulo, String profesor, Dia dia, Turno turno) {
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }


    public Curso(Integer id, String titulo, String profesor, Dia dia, Turno turno) {
        this.id = id;
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }


    @Override
    public String toString() {
        return "Curso [id=" + id + ", titulo=" + titulo + ", profesor=" + profesor + ", dia=" + dia + ", turno=" + turno
                + "]";
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getProfesor() {
        return profesor;
    }


    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }


    public Dia getDia() {
        return dia;
    }


    public void setDia(Dia dia) {
        this.dia = dia;
    }


    public Turno getTurno() {
        return turno;
    }


    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    
}