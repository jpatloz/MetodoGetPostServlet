package edu.dws.ejemploWeb.aplicacion.dal;

/*
 * Interfaz que contiene los métodos que hay que implementar 
 */

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestionOrdenadoresServicio extends CrudRepository<GestionOrdenadores, Long>{


}
