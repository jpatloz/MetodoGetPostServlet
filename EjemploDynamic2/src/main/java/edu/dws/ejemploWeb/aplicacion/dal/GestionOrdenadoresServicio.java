package edu.dws.ejemploWeb.aplicacion.dal;

/*
 * Interfaz que contiene los métodos que hay que implementar 
 */

import java.util.List;

public interface GestionOrdenadoresServicio {

	public void insertarOrdenador(GestionOrdenadores gestionOrdenadores);

	public List<GestionOrdenadores> buscarOrdenadores();
	
	public GestionOrdenadores buscarOrdenadorporIdAlum(long idALum);

}
