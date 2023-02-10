package edu.dws.ejemploWeb;

public class ClaseAlumno {

	private String nombre;
	private String apellidos;
	private int edad;
	
	public ClaseAlumno(String nombre, String apellidos, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	public ClaseAlumno() {
		super();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "-Alumno: nombre: " + nombre + ", apellidos: " + apellidos + ", edad: " + edad + ".";
	}	
}
