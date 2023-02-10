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

import edu.dws.ejemploWeb.ClaseAlumno;


@WebServlet("/OnGetPost")
public class OnGetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;


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
		ClaseAlumno alumno = new ClaseAlumno(nombre, apellidos, nEdad);
		request.setAttribute("alumno", alumno);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/vistas/registro.jsp");
		rd.forward(request, response);
	}

}
