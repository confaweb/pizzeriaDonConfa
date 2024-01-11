package ar.com.pizzeriaDonConfa.dominio.persona;

import java.util.ArrayList;

import ar.com.pizzeriaDonConfa.dominio.pizzeria.Mesa;
import ar.com.pizzeriaDonConfa.enums.CodigoEmpleado;
import ar.com.pizzeriaDonConfa.enums.EstadoMesa;
import ar.com.pizzeriaDonConfa.interfaces.Responsabilidades;

public class Empleado extends Persona implements Comparable<Empleado>,Responsabilidades  {

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
		
		return this.legajo-e.getLegajo();
	}

	@Override
	public Boolean iniciarMesa(Integer numeroDeMesa,ArrayList<Mesa>listadoMesas) {
		Boolean iniciada=false;
		for(Mesa m:listadoMesas) {
			if(m.getNumeroMesa()==numeroDeMesa) {
				m.setEstadoMesa(EstadoMesa.EN_SERVICIO);
				iniciada=true;
			}
				
		}
		return iniciada;
	}

	@Override
	public void abrirComanda(Integer numeroDeMesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer cerrarMesa(Integer numeroDeMesa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean cobrarComanda(Integer numeroMesa) {
		// TODO Auto-generated method stub
		return null;
	}

}
