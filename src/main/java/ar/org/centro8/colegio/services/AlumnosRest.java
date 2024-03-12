package ar.org.centro8.colegio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.centro8.colegio.entities.Alumno;
import ar.org.centro8.colegio.repositories.AlumnoRepository;


@RestController
@RequestMapping("/api")
public class AlumnosRest {

    @Autowired
    private AlumnoRepository ar;

    @GetMapping("/listaAlumnos")
	public List<Alumno> lista(){
		return (List<Alumno>)ar.findAll();
	}
}
