package edu.dws.ejemploWeb.aplicacion.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/*
 * Interfaz que contiene los métodos que hay que implementar 
 */

public interface GestionAlumnosServicio extends CrudRepository<GestionAlumnos, Long>{

}
