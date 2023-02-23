package edu.dws.ejemploWeb.web.Controladores;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.dws.ejemploWeb.aplicacion.Servicios.Servicios;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;
import edu.dws.ejemploWeb.aplicacion.dto.ADaoServicio;
import edu.dws.ejemploWeb.aplicacion.dto.ADaoServicioImpl;

@Controller
public class ControladorBajaAlumno {

	@Autowired
	Servicios consulta = new Servicios();
	
	
	 protected final Log logger = LogFactory.getLog(getClass());
	    
	 Map<String, Object> miModelo = new HashMap<String, Object>();
	 ADaoServicio aDao = new ADaoServicioImpl();
	 GestionAlumnos gestionAlumnos =new GestionAlumnos();
	 
	 
	
}
