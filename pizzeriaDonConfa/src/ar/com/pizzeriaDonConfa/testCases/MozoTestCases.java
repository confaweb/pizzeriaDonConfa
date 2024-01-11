package ar.com.pizzeriaDonConfa.testCases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Bebida;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Carta;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Item;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Postre;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Principal;
import ar.com.pizzeriaDonConfa.dominio.persona.Empleado;
import ar.com.pizzeriaDonConfa.dominio.persona.Persona;
import ar.com.pizzeriaDonConfa.dominio.pizzeria.Mesa;
import ar.com.pizzeriaDonConfa.dominio.pizzeria.Pizzeria;
import ar.com.pizzeriaDonConfa.enums.Categoria;
import ar.com.pizzeriaDonConfa.enums.Clase;
import ar.com.pizzeriaDonConfa.enums.CodigoEmpleado;
import ar.com.pizzeriaDonConfa.enums.EstadoMesa;
import ar.com.pizzeriaDonConfa.enums.Tamanio;
import ar.com.pizzeriaDonConfa.enums.Tipo;

public class MozoTestCases {

	@Test
	public void queExistaUnMozoEnUnaPizzeria() {
//		PREPARACION
		String nombre = "Pedro", apellido = "Lopez";
		Integer dni = 111111, legajo = 0001;
		CodigoEmpleado codigoFuncion = CodigoEmpleado.M01;

//		EJECUCION

		Persona mozo1 = new Empleado(nombre, apellido, dni, legajo, codigoFuncion);
//		VALIDACION

		assertNotNull(mozo1);
	}

	@Test // #2
	public void queSePuedaRegistrarEmpleadoEnLaPizzeria() {
//		PREPARACION
		String nombre = "Pedro", apellido = "Lopez", nombrePizzeria = "donConfa", domicilio = "alberdi 2222",
				eMail = "pizzaDC@xml.com", instagram = "@pDcok", facebook = "pDC";
		Integer dni = 111111, legajo = 0001, telefono = 1118585, cuit = 1111111111;
		CodigoEmpleado codigoFuncion = CodigoEmpleado.M01;

//		EJECUCION

		Persona mozo1 = new Empleado(nombre, apellido, dni, legajo, codigoFuncion);
		Pizzeria donConfa = new Pizzeria(nombrePizzeria, cuit, domicilio, telefono, eMail, instagram, facebook);

//		VALIDACION

		assertTrue(donConfa.registrarEmpleado((Empleado) mozo1));
	}

	@Test // #3
	public void queSePuedaConfeccionarCartaMenu() {
//		PREPARACION
		Categoria categoria = Categoria.VINOS;
		Tipo tipo = Tipo.BEBIDAS, tipo_01 = Tipo.PRINCIPAL, tipo_02 = Tipo.POSTRE;
		Clase clase = Clase.SIN_ALCOHOL;
		Double precio = 1000.00, precio_01 = 2000.00, precio_02 = 3000.00;
		Tamanio tamanio = Tamanio.PEQUENIO;
		String descripcion = "Agua Tónica", descripcion_01 = "MIlanesa con Papas", descripcion_02 = "Flan",
				codigoItem = "B_01", codigoItem_01 = "Pr_01", codigoItem_02 = "Po_01";
//		EJECUCION
		Carta cartaMenu = new Carta(categoria);
		Item gaseosa = new Bebida(codigoItem, descripcion, precio, tamanio, tipo);
		Item menu1 = new Principal(codigoItem_01, descripcion_01, precio_01, tamanio, tipo_01);
		Item postre1 = new Postre(codigoItem_02, descripcion_02, precio_02, tamanio, tipo_02);

		cartaMenu.agregarItem(gaseosa);
		cartaMenu.agregarItem(menu1);
		cartaMenu.agregarItem(postre1);

//		VALIDACION

		Item ve = (Bebida) gaseosa;
		Item vo = cartaMenu.getCartaBebidas().get(codigoItem);
		assertEquals(ve, vo);
		Item ve1 = (Principal) menu1;
		Item vo1 = cartaMenu.getCartaPrincipal().get(codigoItem_01);
		assertEquals(ve1, vo1);
		Item ve2 = (Postre) postre1;
		Item vo2 = cartaMenu.getCartaPostre().get(codigoItem_02);
		assertEquals(ve2, vo2);
	}

	@Test // #4
	public void queSePuedaCambiarPrecio() {
//		PREPARACION
		Categoria categoria = Categoria.VINOS;
		Tipo tipo = Tipo.BEBIDAS, tipo_01 = Tipo.PRINCIPAL, tipo_02 = Tipo.POSTRE;
		Clase clase = Clase.SIN_ALCOHOL;
		Double precio = 1000.00, precio_01 = 2000.00, precio_02 = 3000.00, precioNUevo = 4000.00;
		Tamanio tamanio = Tamanio.PEQUENIO;
		String descripcion = "Agua Tónica", descripcion_01 = "MIlanesa con Papas", descripcion_02 = "Flan",
				codigoItem = "B_01", codigoItem_01 = "Pr_01", codigoItem_02 = "Po_01";
//		EJECUCION
		Carta cartaMenu = new Carta(categoria);
		Item gaseosa = new Bebida(codigoItem, descripcion, precio, tamanio, tipo);
		Item menu1 = new Principal(codigoItem_01, descripcion_01, precio_01, tamanio, tipo_01);
		Item postre1 = new Postre(codigoItem_02, descripcion_02, precio_02, tamanio, tipo_02);

		cartaMenu.cambiarPrecio(postre1, precioNUevo);

//		VALIDACION

		Double ve = precioNUevo;
		Double vo = postre1.getPrecio();
		assertEquals(ve, vo, .01);

	}

	@Test // #5
	public void queSePuedaCrearUnaMesa() {
//		PREPARACION
		Categoria categoria = Categoria.VINOS;
		Tipo tipo = Tipo.BEBIDAS, tipo_01 = Tipo.PRINCIPAL, tipo_02 = Tipo.POSTRE;
		Clase clase = Clase.SIN_ALCOHOL;
		Double precio = 1000.00, precio_01 = 2000.00, precio_02 = 3000.00, precioNUevo = 4000.00;
		Tamanio tamanio = Tamanio.PEQUENIO;
		String descripcion = "Agua Tónica", descripcion_01 = "MIlanesa con Papas", descripcion_02 = "Flan",
				codigoItem = "B_01", codigoItem_01 = "Pr_01", codigoItem_02 = "Po_01";
		Integer numeroMesa = 1, cantidadComensales = 0;
		EstadoMesa estadoMesa = EstadoMesa.VACIA;
//		EJECUCION
		Mesa mesa1 = new Mesa(numeroMesa, estadoMesa, cantidadComensales);

//		VALIDACION

		assertNotNull(mesa1);
	}
	@Test // #6

	public void queMozoIniciasUnaUnaMesa() {
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
		ArrayList <Mesa>listadoMesa=new ArrayList<Mesa>();
		
		listadoMesa.add(mesa1);

		((Empleado) mozo1).iniciarMesa(numeroMesa, listadoMesa);

//		VALIDACION

		EstadoMesa ve = EstadoMesa.EN_SERVICIO;
		EstadoMesa vo = mesa1.getEstadoMesa();
		assertEquals(ve, vo);
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * #4 queSePuedaRealizarComandaPorUnMozo# #5
	 * QueSeCierreComandaYCalculeCuentaACobrar #6 CobrarComanda #7
	 * calcularRecaudacionTotalPorMesa #8 calcularRecaudacionTotalDelDia ####
	 * 
	 */
}
