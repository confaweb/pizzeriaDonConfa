package ar.com.pizzeriaDonConfa.testCases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Bebida;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Carta;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Item;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Postre;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Principal;
import ar.com.pizzeriaDonConfa.dominio.persona.Empleado;
import ar.com.pizzeriaDonConfa.dominio.persona.Persona;
import ar.com.pizzeriaDonConfa.dominio.pizzeria.Comanda;
import ar.com.pizzeriaDonConfa.dominio.pizzeria.Mesa;
import ar.com.pizzeriaDonConfa.enums.Categoria;
import ar.com.pizzeriaDonConfa.enums.Clase;
import ar.com.pizzeriaDonConfa.enums.CodigoEmpleado;
import ar.com.pizzeriaDonConfa.enums.EstadoComanda;
import ar.com.pizzeriaDonConfa.enums.EstadoMesa;
import ar.com.pizzeriaDonConfa.enums.Tamanio;
import ar.com.pizzeriaDonConfa.enums.Tipo;
import ar.com.pizzeriaDonConfa.exception.ComandaSinAbrirException;

public class MozoTestCases {

	@Test // #1

	public void queMozoInicieUnaUnaMesa() {
//		PREPARACION
		Categoria categoria = Categoria.VINOS;
		Tipo tipo = Tipo.BEBIDAS, tipo_01 = Tipo.PRINCIPAL, tipo_02 = Tipo.POSTRE;
		Clase clase = Clase.SIN_ALCOHOL;
		Double precio = 1000.00, precio_01 = 2000.00, precio_02 = 3000.00, precioNUevo = 4000.00;
		Tamanio tamanio = Tamanio.PEQUENIO;
		String descripcion = "Agua Tónica", descripcion_01 = "MIlanesa con Papas", descripcion_02 = "Flan",
				codigoItem = "B_01", codigoItem_01 = "Pr_01", codigoItem_02 = "Po_01", nombre = "Pedro",
				apellido = "Lopez";
		Integer numeroMesa = 1, cantidadComensales = 0, dni = 111111, legajo = 0001;
		EstadoMesa estadoMesa = EstadoMesa.VACIA;
		CodigoEmpleado codigoFuncion = CodigoEmpleado.M01;
//		EJECUCION
		Mesa mesa1 = new Mesa(numeroMesa, estadoMesa, cantidadComensales);
		Persona mozo1 = new Empleado(nombre, apellido, dni, legajo, codigoFuncion);
		Set<Mesa> listadoMesa = new HashSet<Mesa>();

		listadoMesa.add(mesa1);

		((Empleado) mozo1).iniciarMesa(numeroMesa, listadoMesa);

//		VALIDACION

		EstadoMesa ve = EstadoMesa.EN_SERVICIO;
		EstadoMesa vo = mesa1.getEstadoMesa();
		assertEquals(ve, vo);
	}

	@Test // #2
	public void queUnMozoqueUnMozoPuedaagregarItemALaComandaPorSuDescripcion() throws ComandaSinAbrirException {
//		PREPARACION
		Categoria categoria = Categoria.VINOS;
		Tipo tipo = Tipo.BEBIDAS, tipo_01 = Tipo.PRINCIPAL, tipo_02 = Tipo.POSTRE;
		Clase clase = Clase.SIN_ALCOHOL;
		Double precio = 1000.00, precio_01 = 2000.00, precio_02 = 3000.00, precioNUevo = 4000.00, montoTotal = 0.00;
		Tamanio tamanio = Tamanio.PEQUENIO;
		String descripcion = "Agua Tónica", descripcion_01 = "MIlanesa con Papas", descripcion_02 = "Flan",
				codigoItem = "B_01", codigoItem_01 = "Pr_01", codigoItem_02 = "Po_01", nombre = "Pedro",
				apellido = "Lopez";
		Integer numeroMesa = 1, cantidadComensales = 0, dni = 111111, legajo = 0001;
		EstadoMesa estadoMesa = EstadoMesa.VACIA;
		CodigoEmpleado codigoFuncion = CodigoEmpleado.M01;
		EstadoComanda estadoComanda = EstadoComanda.ABIERTA;
//		EJECUCION

		Mesa mesa1 = new Mesa(numeroMesa, estadoMesa, cantidadComensales);
		Persona mozo1 = new Empleado(nombre, apellido, dni, legajo, codigoFuncion);
		Comanda comanda = new Comanda(numeroMesa, estadoComanda, montoTotal);
		Set<Mesa> listadoMesa = new HashSet<Mesa>();
		Carta carta = new Carta(categoria);

		listadoMesa.add(mesa1);

		Item gaseosa = new Bebida(codigoItem, descripcion, precio, tamanio, tipo);
		Item menu1 = new Principal(codigoItem_01, descripcion_01, precio_01, tamanio, tipo_01);
		Item postre1 = new Postre(codigoItem_02, descripcion_02, precio_02, tamanio, tipo_02);

		carta.agregarItem(gaseosa);
		carta.agregarItem(postre1);
		carta.agregarItem(menu1);

		((Empleado) mozo1).iniciarMesa(numeroMesa, listadoMesa);
		((Empleado) mozo1).abrirComanda(comanda, numeroMesa);

//		VALIDACION

		assertTrue(((Empleado) mozo1).agregarItemAComanda(menu1, comanda));

		Double ve = precio_01;
		Double vo = comanda.getFactura().get(descripcion_01);
		assertEquals(ve, vo);
	}

	@Test // #3
	public void queSePuedaCerrarComandaPorUnMozo() throws ComandaSinAbrirException {
		// PREPARACION
		Categoria categoria = Categoria.VINOS;
		Tipo tipo = Tipo.BEBIDAS, tipo_01 = Tipo.PRINCIPAL, tipo_02 = Tipo.POSTRE;
		Clase clase = Clase.SIN_ALCOHOL;
		Double precio = 1000.00, precio_01 = 2000.00, precio_02 = 3000.00, precioNUevo = 4000.00, montoTotal = 0.00;
		Tamanio tamanio = Tamanio.PEQUENIO;
		String descripcion = "Agua Tónica", descripcion_01 = "MIlanesa con Papas", descripcion_02 = "Flan",
				codigoItem = "B_01", codigoItem_01 = "Pr_01", codigoItem_02 = "Po_01", nombre = "Pedro",
				apellido = "Lopez";
		Integer numeroMesa = 1, cantidadComensales = 0, dni = 111111, legajo = 0001;
		EstadoMesa estadoMesa = EstadoMesa.VACIA;
		CodigoEmpleado codigoFuncion = CodigoEmpleado.M01;
		EstadoComanda estadoComanda = EstadoComanda.ABIERTA;
//		EJECUCION

		Mesa mesa1 = new Mesa(numeroMesa, estadoMesa, cantidadComensales);
		Persona mozo1 = new Empleado(nombre, apellido, dni, legajo, codigoFuncion);
		Comanda comanda = new Comanda(numeroMesa, estadoComanda, montoTotal);
		Set<Mesa> listadoMesa = new HashSet<Mesa>();
		Carta carta = new Carta(categoria);

		listadoMesa.add(mesa1);

		Item gaseosa = new Bebida(codigoItem, descripcion, precio, tamanio, tipo);
		Item menu1 = new Principal(codigoItem_01, descripcion_01, precio_01, tamanio, tipo_01);
		Item postre1 = new Postre(codigoItem_02, descripcion_02, precio_02, tamanio, tipo_02);

		((Empleado) mozo1).agregarItemAComanda(gaseosa, comanda);
		((Empleado) mozo1).agregarItemAComanda(menu1, comanda);
		((Empleado) mozo1).agregarItemAComanda(postre1, comanda);

		carta.agregarItem(gaseosa);
		carta.agregarItem(postre1);
		carta.agregarItem(menu1);

//		VALIDACION

		Double ve = 6000.0;
		Double vo = ((Empleado) mozo1).cerrarMesa(comanda, numeroMesa);
		assertEquals(ve, vo, .01);
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * #4 # #5 QueSeCierreComandaYCalculeCuentaACobrar #6 CobrarComanda #7
	 * calcularRecaudacionTotalPorMesa #8 calcularRecaudacionTotalDelDia ####
	 * 
	 */
}
