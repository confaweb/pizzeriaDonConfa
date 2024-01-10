package ar.com.pizzeriaDonConfa.dominio.pizzeria;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import ar.com.pizzeriaDonConfa.dominio.persona.Empleado;
import ar.com.pizzeriaDonConfa.dominio.persona.Persona;

public class Pizzeria {

	private String nombrePizzeria;
	private Integer cuit;
	private String domicilio;
	private Integer telefono;
	private String eMail;
	private String facebook;
	private Set<Empleado> registroEmpleados;

	public Pizzeria(String nombrePizzeria, Integer cuit, String domicilio, Integer telefono, String eMail,
			String instagram, String facebook) {
		this.nombrePizzeria = nombrePizzeria;
		this.cuit = cuit;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.eMail = eMail;
		this.facebook = facebook;
		this.registroEmpleados = new TreeSet<Empleado>();
	}

	public String getNombrePizzeria() {
		return nombrePizzeria;
	}

	public void setNombrePizzeria(String nombrePizzeria) {
		this.nombrePizzeria = nombrePizzeria;
	}

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public Set<Empleado> getRegistroEmpleados() {
		return registroEmpleados;
	}

	public void setRegistroEmpleados(Set<Empleado> registroEmpleados) {
		this.registroEmpleados = registroEmpleados;
	}

	public Boolean registrarEmpleado(Empleado mozo1) {
		Boolean empleadoRegistrado = false;
		empleadoRegistrado = registroEmpleados.add(mozo1);
		return empleadoRegistrado;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(cuit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizzeria other = (Pizzeria) obj;
		return Objects.equals(cuit, other.cuit);
	}

	@Override
	public String toString() {
		return "Pizzeria [nombrePizzeria=" + nombrePizzeria + ", cuit=" + cuit + ", domicilio=" + domicilio
				+ ", telefono=" + telefono + ", eMail=" + eMail + ", facebook=" + facebook + "]";
	}

}
