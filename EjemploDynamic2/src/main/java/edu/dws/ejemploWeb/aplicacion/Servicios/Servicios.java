package edu.dws.ejemploWeb.aplicacion.Servicios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnosServicio;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadoresServicio;

public class Servicios{

	@Autowired
	private GestionAlumnosServicio gas;
	@Autowired
	private GestionOrdenadoresServicio gos;
	
	@Transactional
	public void insertarUnaMatricula(GestionAlumnos gestionAlumnos) {
		gas.save(gestionAlumnos);
	}
	
	//Consulta para buscar todos los alumnos 
	
	public List<GestionAlumnos> buscarTodos(){
        return (List<GestionAlumnos>) gas.findAll();
    }
	
	//Consulta para eliminar a un alumno
	
	//@Transactional
	//public void eliminarUnAlumno(long id) {
	//	gas.deleteById(id);
	//}
	
	//COnsulta para buscar un alumno por id de ordenador
	
	/*
	@Transactional
	public GestionAlumnos buscarAlumnoPorIdOrdenador(long idOrd) {
		return gas.findAllById(idOrd);
	}
	*/
	
	
	//Consultas de gestión de ordenadores

		//Consulta para insertar un ordenador
		
		@Transactional
		public void insertarUnOrdenador(GestionOrdenadores gestionOrdenadores) {
			gos.save(gestionOrdenadores);
		}

		//Consulta para buscar un ordenador por id de alumno
		
		//public GestionOrdenadores buscarOrdenadorPorIdAlumno(long idAlum) {
		//	return gos.buscarOrdenadorporIdAlum(idAlum);
		//}
		
		//Consulta para buscar un ordenador
		public List<GestionOrdenadores> buscarOrdenadores() {
			return (List<GestionOrdenadores>) gos.findAll();
		}
		
	
}
