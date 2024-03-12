package ar.org.centro8.colegio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.centro8.colegio.entities.Curso;
import ar.org.centro8.colegio.repositories.CursoRepository;

@RestController
@RequestMapping("/api")
public class CursosRest {
    
    @Autowired
    private CursoRepository cr;

    @GetMapping("/listacursos")
	public List<Curso> lista(){
		return (List<Curso>)cr.findAll();
	}
}
