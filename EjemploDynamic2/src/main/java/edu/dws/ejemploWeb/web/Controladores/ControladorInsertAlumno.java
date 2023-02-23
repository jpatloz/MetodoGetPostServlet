package edu.dws.ejemploWeb.web.Controladores;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.ejemploWeb.aplicacion.Servicios.Servicios;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;
import edu.dws.ejemploWeb.aplicacion.dto.ADaoServicio;
import edu.dws.ejemploWeb.aplicacion.dto.ADaoServicioImpl;
import edu.dws.ejemploWeb.aplicacion.dto.GestionAlumnosDTO;
import edu.dws.ejemploWeb.aplicacion.dto.GestionOrdenadoresDTO;

@Controller
public class ControladorInsertAlumno {

	@Autowired
	Servicios consulta = new Servicios();

	protected final Log logger = LogFactory.getLog(getClass());

	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new ADaoServicioImpl();
	GestionAlumnos gestionAlumnos = new GestionAlumnos();

	@RequestMapping(value = "/formularioAlumno")
	public String navegacionFormulario(Model modelo) {
		logger.info("Navegamos al formulario");
		GestionAlumnosDTO gestionAlumnos = new GestionAlumnosDTO();
		modelo.addAttribute("alumnoInsertado", gestionAlumnos);
		return "registroAlumno";
	}

	@RequestMapping(value = "/guardarAlumno", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@ModelAttribute("alumnoInsertado") GestionAlumnosDTO alumnoInsertado) {

		gestionAlumnos = aDao.GestionAlumnosDTOADAO(alumnoInsertado);

		consulta.insertarUnaMatricula(gestionAlumnos);

		miModelo.put("mensaje", "Alumno matriculado");

		return new ModelAndView("registroAlumno", "miModelo", miModelo);
	}

}
