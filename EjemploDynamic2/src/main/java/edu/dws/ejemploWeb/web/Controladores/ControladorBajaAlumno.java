package edu.dws.ejemploWeb.web.Controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.ejemploWeb.aplicacion.Servicios.Servicios;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;
import edu.dws.ejemploWeb.aplicacion.dto.ADaoServicio;
import edu.dws.ejemploWeb.aplicacion.dto.ADaoServicioImpl;
import edu.dws.ejemploWeb.aplicacion.dto.ADtoServicio;
import edu.dws.ejemploWeb.aplicacion.dto.ADtoServicioImpl;
import edu.dws.ejemploWeb.aplicacion.dto.GestionAlumnosDTO;
import edu.dws.ejemploWeb.aplicacion.dto.GestionOrdenadoresDTO;

@Controller
public class ControladorBajaAlumno {

	 protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	Servicios consulta = new Servicios();

	 Map<String, Object> miModelo = new HashMap<String, Object>();
	 ADaoServicioImpl aDao = new ADaoServicioImpl(); 
	
	 @RequestMapping(value="/bajaAlumno")
	 public String formularioDelete(Model modelo) {
	        logger.info("Dirigiendo al formulario de baja de alumno");
	        GestionAlumnos gestionAlumnos = new GestionAlumnos();
	        
	        modelo.addAttribute("bajaAlumno", gestionAlumnos);
	        return "bajaAlumno"; 
	 }
	 
	 @RequestMapping(value = "/eliminarAlumno", method = RequestMethod.POST)
		public ModelAndView eliminarAumno( @RequestParam long id) {
		 
		consulta.eliminarUnAlumno(id);
		
		List<GestionAlumnos> gestionAlumnos = new ArrayList<>();
		
		gestionAlumnos = consulta.buscarAlumnos();	

		miModelo.put("mensaje", "El ordenador con el id indicado ha sido eliminado");

		return new ModelAndView("bajaAlumno", "miModelo", miModelo);
	}
}
