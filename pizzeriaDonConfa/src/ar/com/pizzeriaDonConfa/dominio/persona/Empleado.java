package ar.com.pizzeriaDonConfa.dominio.persona;

import ar.com.pizzeriaDonConfa.enums.Codigo;

public class Empleado extends Persona {

	private Integer legajo;
	private Codigo codigoFuncion;
	

	public Empleado(String nombre, String apellido, Integer dni, Integer legajo, Codigo codigoFuncion) {
		super(nombre, apellido, dni);
		super.nombre = nombre;
		super.apellido = apellido;
		super.dni = dni;
		this.legajo = legajo;
		this.codigoFuncion = codigoFuncion;
	}


	public Integer getLegajo() {
		return legajo;
	}


	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}


	public Codigo getCodigoFuncion() {
		return codigoFuncion;
	}


	public void setCodigoFuncion(Codigo codigoFuncion) {
		this.codigoFuncion = codigoFuncion;
	}

}
