package edu.dws.ejemploWeb.aplicacion.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * Interfaz que contiene los métodos que hay que implementar 
 */

@Repository
public interface GestionAlumnosServicio extends CrudRepository<GestionAlumnos, Long>{

}
