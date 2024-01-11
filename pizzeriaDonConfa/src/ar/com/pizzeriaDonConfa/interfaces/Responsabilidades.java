package ar.com.pizzeriaDonConfa.interfaces;

import java.util.ArrayList;

import ar.com.pizzeriaDonConfa.dominio.pizzeria.Mesa;

public interface Responsabilidades {
	Boolean iniciarMesa(Integer numeroDeMesa,ArrayList<Mesa>listadoMesas);

	void abrirComanda(Integer numeroDeMesa);

	Integer cerrarMesa(Integer numeroDeMesa);

	Boolean cobrarComanda(Integer numeroMesa);

}
