package ar.com.pizzeriaDonConfa.dominio.persona;

import ar.com.pizzeriaDonConfa.enums.CodigoEmpleado;

public class Empleado extends Persona implements Comparable<Empleado>  {

	private Integer legajo;
	private CodigoEmpleado codigoFuncion;

	public Empleado(String nombre, String apellido, Integer dni, Integer legajo, CodigoEmpleado codigoFuncion) {
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

	public CodigoEmpleado getCodigoFuncion() {
		return codigoFuncion;
	}

	public void setCodigoFuncion(CodigoEmpleado codigoFuncion) {
		this.codigoFuncion = codigoFuncion;
	}

	

	

	@Override
	public int compareTo(Empleado e) {
		// TODO Auto-generated method stub
		return this.legajo-e.getLegajo();
	}

}
