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
import edu.dws.ejemploWeb.aplicacion.dto.GestionAlumnosDTO;
import edu.dws.ejemploWeb.aplicacion.dto.GestionOrdenadoresDTO;

@Controller
public class ControladorInsertAlumno {

	@Autowired
	Servicios consulta = new Servicios();

	protected final Log logger = LogFactory.getLog(getClass());

	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new ADaoServicioImpl();

	@RequestMapping(value = "/formularioAlumno")
	public String formularioMatricula(Model modelo) {
		logger.info("Dirigiendo al formulario de alumnos");
		GestionAlumnosDTO gestionAlumnosDTO = new GestionAlumnosDTO();
		
		modelo.addAttribute("alumnoInsertado", gestionAlumnosDTO);
		return "registroAlumno";
	}
	
	@RequestMapping(value = "/guardarAlumno", method = RequestMethod.POST)
	public ModelAndView insertarMatricula(@ModelAttribute("alumnoInsertado") GestionAlumnosDTO gestionAlumnosDTO){
	
		List<Integer> listaOrdenadores = new ArrayList<>();
		
		GestionOrdenadores ordenador = new GestionOrdenadores();

		for(GestionAlumnos gestionAlumnos: consulta.buscarAlumnos()) {
			
			if(gestionAlumnos.getOrdenadores() != null) {
				listaOrdenadores.add((int) gestionAlumnos.getOrdenadores().getId_ordenador());
			}
			
		for(GestionOrdenadores gestionOrdenadores: consulta.buscarOrdenadores()) {
			
			if(!listaOrdenadores.contains(ordenador.getId_ordenador())) {
				ordenador = gestionOrdenadores;
			}else{
				ordenador = new GestionOrdenadores();
			}
		}
	}
		
		//Asignamos un ordenador a un alumno
		gestionAlumnosDTO.setOrdenadores(ordenador);
		
		//Insertamos un alumno
		consulta.insertarUnaMatricula(aDao.GestionAlumnosDTOADAO(gestionAlumnosDTO));
		
		miModelo.put("mensaje", "Alumno matriculado");

		return new ModelAndView("registroAlumno", "miModelo", miModelo);
		}
	
	}

