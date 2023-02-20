package edu.dws.ejemploWeb.web.Controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	ApplicationContext context= new ClassPathXmlApplicationContext("AplicacionConfiguracionContexto");
	//LLamamos a la clase consultas y creamos una instancia 
	Servicios consulta = (Servicios) context.getBean(Servicios.class);
	
	//Creamos el md_uuid de forma que se genere de forma aleatoria dentro de la base de datos
	String md_uuid = java.util.UUID.randomUUID().toString();
	
	//Opcion del menu
	Integer opcion1;
	
	//Creamos una lista para meter el id de ordenador
	List<GestionOrdenadores> lista = new ArrayList();
	lista = consulta.buscarOrdenadores();
	
	//Creamos una instancia de nuestras clases para Dao y Dto
	ADtoServicioImpl aDto = new ADtoServicioImpl();
	ADaoServicioImpl aDao = new ADaoServicioImpl();
	
	Calendar fecha = Calendar.getInstance();
	
	//DTO para el pago repostaje
	GestionAlumnosDTO DTOAlumnos;
	GestionAlumnos gestionAlumnos = new GestionAlumnos();
			
	//DTO para el control camiones
	GestionOrdenadoresDTO DTOOrdenadores;
	GestionOrdenadores gestionOrdenadores = new GestionOrdenadores();
	
	 protected final Log logger = LogFactory.getLog(getClass());
	 
	    @RequestMapping(value="/segunda")
	    public ModelAndView gestionSolicitud() {
	        logger.info("Navegamos a la vista segunda");
	        List<GestionAlumnos> alumno = new ArrayList();
	        
	        System.out.println("Ha escogido la opcion de matricular a un alumno: ");
			//Añadimos los valores al DTO de alumnos
			DTOAlumnos = aDto.AGestionAlumnosDTO(fecha, "Jesus", "Patricio Lozano", "954654567", lista.get(1));
			//Convertimos la consulta a DAO
			gestionAlumnos = aDao.GestionAlumnosDTOADAO(DTOAlumnos);
			alumno.add(gestionAlumnos);
			
	        Map<String, Object> clase = new HashMap<String, Object>();
	        clase.put("atributos", alumno);
	        return new ModelAndView("segunda", "clase", clase);
	    } 
}
