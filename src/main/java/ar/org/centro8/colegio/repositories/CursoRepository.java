package ar.org.centro8.colegio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.org.centro8.colegio.entities.Curso;

@Repository
public interface CursoRepository 
            extends CrudRepository<Curso, Integer> {
    
}


