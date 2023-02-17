package edu.dws.ejemploWeb.aplicacion.dto;

import java.util.Calendar;

import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;

/*
 * Interfaz para definir los métodos para el DTO
 */

public interface ADtoServicio {

	public GestionAlumnosDTO AGestionAlumnosDTO(Calendar md_date, String nombre_alumno,
			String apellidos_alumno, String num_telefono, GestionOrdenadores ordenadores);
	
	public GestionOrdenadoresDTO AGestionOrdenadoresDTO(Calendar md_date, String modelo, String marca);
}
