package ar.com.pizzeriaDonConfa.dominio.persona;

import java.util.ArrayList;
import java.util.Set;
import java.util.Map;

import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Bebida;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Carta;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Item;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Postre;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Principal;
import ar.com.pizzeriaDonConfa.dominio.pizzeria.Comanda;
import ar.com.pizzeriaDonConfa.dominio.pizzeria.Mesa;
import ar.com.pizzeriaDonConfa.enums.CodigoEmpleado;
import ar.com.pizzeriaDonConfa.enums.EstadoComanda;
import ar.com.pizzeriaDonConfa.enums.EstadoMesa;
import ar.com.pizzeriaDonConfa.enums.Tamanio;
import ar.com.pizzeriaDonConfa.enums.Tipo;
import ar.com.pizzeriaDonConfa.exception.ComandaSinAbrirException;
import ar.com.pizzeriaDonConfa.interfaces.Responsabilidades;

public class Empleado extends Persona implements Comparable<Empleado>, Responsabilidades {

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

		return this.legajo - e.getLegajo();
	}

	@Override
	public Boolean iniciarMesa(Integer numeroDeMesa, Set<Mesa> listadoMesa) {
		Boolean iniciada = false;
		for (Mesa m : listadoMesa) {
			if (m.getNumeroMesa() == numeroDeMesa) {
				m.setEstadoMesa(EstadoMesa.EN_SERVICIO);
				iniciada = true;
			}

		}
		return iniciada;
	}

	@Override
	public void abrirComanda(Comanda comanda, Integer numeroMesa) {
		comanda.setEstadoComanda(EstadoComanda.ABIERTA);
		comanda.setNumeroMesa(numeroMesa);
		comanda.setMontoTotal(0.00);

	}

	@Override
	public Boolean agregarItemAComanda(Item item, Comanda comanda) throws ComandaSinAbrirException {
		Boolean agregado = false;
		if (checkComanda(comanda))
			agregado = comanda.agregarItem(item);
		else
			throw new ComandaSinAbrirException("Primero debeabrir comanda");

		return agregado;
	}

	public Item seleccionarItemAComanda(String descripcion, Tipo tipo, Carta carta) {

		Item seleccion;
		if (tipo == Tipo.BEBIDAS)
			seleccion = seleccionarBebidas(carta.getCartaBebidas(), descripcion);
		else if (tipo == Tipo.POSTRE)
			seleccion = seleccionarPostre(carta.getCartaPostre(), descripcion);
		else
			seleccion = seleccionarPrincipal(carta.getCartaPrincipal(), descripcion);

		return seleccion;

	}

	private boolean checkComanda(Comanda comanda) {
		boolean comandaAbierta = false;
		if (comanda.getEstadoComanda() == EstadoComanda.ABIERTA)
			comandaAbierta = true;
		return comandaAbierta;
	}

	private Item seleccionarBebidas(Map<String, Bebida> cartaBebida, String descripcion) {
		Item seleccionado = null;
		if (cartaBebida.containsKey(descripcion))
			seleccionado = cartaBebida.get(descripcion);
		return seleccionado;

	}

	private Item seleccionarPostre(Map<String, Postre> cartaPostre, String descripcion) {
		Item seleccionado = null;
		if (cartaPostre.containsKey(descripcion))
			seleccionado = cartaPostre.get(descripcion);
		return seleccionado;

	}

	private Item seleccionarPrincipal(Map<String, Principal> cartaPrincipal, String descripcion) {
		Item seleccionado = null;
		if (cartaPrincipal.containsKey(descripcion))
			seleccionado = cartaPrincipal.get(descripcion);
		return seleccionado;

	}

	@Override
	public Double cerrarMesa(Comanda comanda, Integer numeroDeMesa) {
		Double montoTotal = 0.0;
		if (comanda.getNumeroMesa() == numeroDeMesa)
			montoTotal = sumarComanda(comanda);
		return montoTotal;

	}

	private Double sumarComanda(Comanda comanda) {
		Double montoTotal = 0.0;

		for (int i = 0; i < comanda.getCuenta().size(); i++) {
			montoTotal += comanda.getCuenta().get(i);
		}
		return montoTotal;
	}

	@Override
	public Boolean cobrarComanda(Comanda comanda, Integer numeroMesa) {
		// TODO Auto-generated method stub
		return null;
	}

}
