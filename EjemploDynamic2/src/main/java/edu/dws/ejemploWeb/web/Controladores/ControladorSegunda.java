package edu.dws.ejemploWeb.web.Controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.ejemploWeb.aplicacion.Servicios.Servicios;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;
import edu.dws.ejemploWeb.aplicacion.dto.ADaoServicioImpl;
import edu.dws.ejemploWeb.aplicacion.dto.ADtoServicioImpl;
import edu.dws.ejemploWeb.aplicacion.dto.GestionAlumnosDTO;
import edu.dws.ejemploWeb.aplicacion.dto.GestionOrdenadoresDTO;


@Controller
public class ControladorSegunda {

	@Autowired
	Servicios consulta = new Servicios();
	
	
	 protected final Log logger = LogFactory.getLog(getClass());
	    
	    List<GestionAlumnos> gestionAlumnos = new ArrayList<GestionAlumnos>();
	    List<GestionAlumnosDTO> gestionAlumnosDTO = new ArrayList<GestionAlumnosDTO>();
	    Map<String, Object> miModelo = new HashMap<String, Object>(); 
	    
	    @RequestMapping(value="/segunda")
	    public ModelAndView gestionSolicitud() {
	        logger.info("Navegamos a la vista segunda");
	        
	        miModelo.put("listaAlumnos", gestionAlumnos);
	        return new ModelAndView("segunda", "miModelo", miModelo);
	    } 
	    
	    @RequestMapping(value="/navegacionFormulario")
	    public String navegacionFormulario(Model modelo) {
	        logger.info("Navegamos al formulario");
	        GestionAlumnos gestionAlumnos = new GestionAlumnos();
	        modelo.addAttribute("insertarAlumno", gestionAlumnos);
	        return "registro";
	    } 
	    
	    @RequestMapping(value="/insertarAlumno",method = RequestMethod.POST)
	    public ModelAndView insertarAlumno(@ModelAttribute("insertarAlumno") GestionAlumnos alumno){
	    	logger.info("Navegamos al guardar alumno");
	    	gestionAlumnos.add(alumno);  
	        miModelo.put("mensaje","Todo ok");
	        miModelo.put("listaAlumnos", gestionAlumnos);
	        
	    consulta.insertarUnaMatricula(alumno);
	        
	    	return new ModelAndView("segunda", "miModelo", miModelo);
	    }
	    
}
