package edu.dws.ejemploWeb.web.Controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;



@WebServlet("/OnGetPost")
@Controller
public class OnGetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//LLamamos a nuestro contexto.xml
	//ApplicationContext context= new ClassPathXmlApplicationContext("contexto.xml");


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Ingresamos el metodo GET de MyServlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingresamos el metodo POST de MyServlet");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String edad = request.getParameter("edad");
		int nEdad = Integer.parseInt(edad);
		GestionAlumnos alumno = new GestionAlumnos(nombre, apellidos, nEdad);
		request.setAttribute("alumno", alumno);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/vistas/registro.jsp");
		rd.forward(request, response);
	}

}
