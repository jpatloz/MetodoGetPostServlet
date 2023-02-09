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

import edu.dws.ejemploWeb.ClaseAlumno;


@Controller
public class ControladorSegunda {
	 protected final Log logger = LogFactory.getLog(getClass());
	 
	    @RequestMapping(value="/segunda")
	    public ModelAndView gestionSolicitud() {
	        logger.info("Navegamos a la vista segunda");
	        List<ClaseAlumno> alumno = new ArrayList();
	        ClaseAlumno primerAlumno = new ClaseAlumno("Jesus", "Patricio Lozano", 21);
	        ClaseAlumno segundoAlumno = new ClaseAlumno("Salva", "Sanchez Cardoso", 24);
	        alumno.add(primerAlumno);
	        alumno.add(segundoAlumno);
	        Map<String, Object> clase = new HashMap<String, Object>();
	        clase.put("atributos", alumno);
	        return new ModelAndView("segunda", "clase", clase);
	    } 
}
