package ar.org.centro8.colegio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.org.centro8.colegio.entities.Alumno;

@Repository
public interface AlumnoRepository
            extends CrudRepository<Alumno, Integer> {
    
}