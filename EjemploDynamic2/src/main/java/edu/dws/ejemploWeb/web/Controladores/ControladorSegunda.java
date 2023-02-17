package edu.dws.ejemploWeb.web.Controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;


@Controller
public class ControladorSegunda {
	 protected final Log logger = LogFactory.getLog(getClass());
	 
	    @RequestMapping(value="/segunda")
	    public ModelAndView gestionSolicitud() {
	        logger.info("Navegamos a la vista segunda");
	        List<GestionAlumnos> alumno = new ArrayList();
	        GestionAlumnos primerAlumno = new GestionAlumnos("Jesus", "Patricio Lozano", 21);
	        GestionAlumnos segundoAlumno = new GestionAlumnos("Salva", "Sanchez Cardoso", 24);
	        alumno.add(primerAlumno);
	        alumno.add(segundoAlumno);
	        Map<String, Object> clase = new HashMap<String, Object>();
	        clase.put("atributos", alumno);
	        return new ModelAndView("segunda", "clase", clase);
	    } 
}
