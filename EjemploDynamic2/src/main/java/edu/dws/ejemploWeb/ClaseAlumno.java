package edu.dws.ejemploWeb;

public class ClaseAlumno {

	private String nombre;
	private String apellido;
	private int edad;
	
	public ClaseAlumno(String nombre, String apellido, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "-Alumno: nombre: " + nombre + ", apellido: " + apellido + ", edad: " + edad + ".";
	}	
}
