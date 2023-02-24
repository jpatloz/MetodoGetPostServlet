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
import edu.dws.ejemploWeb.aplicacion.dto.ADaoServicio;
import edu.dws.ejemploWeb.aplicacion.dto.ADaoServicioImpl;
import edu.dws.ejemploWeb.aplicacion.dto.ADtoServicioImpl;
import edu.dws.ejemploWeb.aplicacion.dto.GestionAlumnosDTO;
import edu.dws.ejemploWeb.aplicacion.dto.GestionOrdenadoresDTO;


@Controller
public class ControladorInsertPortatil {

	@Autowired
	Servicios consulta = new Servicios();
	
	
	 protected final Log logger = LogFactory.getLog(getClass());
	    
	 Map<String, Object> miModelo = new HashMap<String, Object>();
	 ADaoServicio aDao = new ADaoServicioImpl();	

		 @RequestMapping(value="/formularioPortatil")
		    public String formularioOrdenador(Model model) {
		        logger.info("Navegamos al formulario");
		        GestionOrdenadoresDTO gestionOrdenadoresDTO = new GestionOrdenadoresDTO();
		        model.addAttribute("ordenadorInsertado", gestionOrdenadoresDTO);
		        return "registroPortatil";
		    } 

		@RequestMapping(value = "/guardarPortatil", method = RequestMethod.POST)
		public ModelAndView guardarPortatil(@ModelAttribute("ordenadorInsertado") GestionOrdenadoresDTO ordenadorInsertado) {
			
			GestionOrdenadores gestionOrdenadores =new GestionOrdenadores();
			
			gestionOrdenadores=aDao.GestionOrdenadoresDTOADAO(ordenadorInsertado);
			
			consulta.insertarUnOrdenador(gestionOrdenadores);
			
			miModelo.put("mensaje", "Ordenador insertado");

			return new ModelAndView("registroPortatil", "miModelo", miModelo);
		}
}
