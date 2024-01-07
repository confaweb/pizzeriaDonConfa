package ar.com.pizzeriaDonConfa.testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.com.pizzeriaDonConfa.dominio.persona.Empleado;
import ar.com.pizzeriaDonConfa.dominio.persona.Persona;
import ar.com.pizzeriaDonConfa.enums.Codigo;

public class MozoTestCases {

	@Test
	public void queExistaUnMozoEnUnaPizzeria() {
//		PREPARACION
		String nombre="Pedro",apellido="Lopez";
		Integer dni=111111,legajo=0001;
		Codigo codigoFuncion= Codigo.M01;
		
		
//		EJECUCION
		
		Persona mozo1 =new Empleado(nombre,apellido,dni,legajo,codigoFuncion);
//		VALIDACION
		
		assertNotNull(mozo1);
	}

/*
 * #2
 * queSePuedaRegistrarEmpleadoEnLaPizzeria
 * #3
 * queSePuedaConfeccionarCartaMenu
 * #4
 * queSePuedaRealizarComandaPorUnMoza#
 * #5
 * QueSeCierreComandaYCalculeCuentaACobrar
 * #6
 * CobrarComanda
 * #7
 * calcularRecaudacionTotalPorMesa
 * #8
 * calcularRecaudacionTotalDelDia
 * ####

 */
}
