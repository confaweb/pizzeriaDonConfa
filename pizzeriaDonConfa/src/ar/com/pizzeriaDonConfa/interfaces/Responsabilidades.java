package ar.com.pizzeriaDonConfa.interfaces;

import java.util.ArrayList;
import java.util.Set;

import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Carta;
import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Item;
import ar.com.pizzeriaDonConfa.dominio.pizzeria.Comanda;
import ar.com.pizzeriaDonConfa.dominio.pizzeria.Mesa;
import ar.com.pizzeriaDonConfa.enums.Tipo;
import ar.com.pizzeriaDonConfa.exception.ComandaSinAbrirException;

public interface Responsabilidades {
	Boolean iniciarMesa(Integer numeroDeMesa, Set<Mesa> listadoMesas);

	void abrirComanda(Comanda comanda, Integer numeroMesa);

	Boolean agregarItemAComanda(Item item, Comanda comanda) throws ComandaSinAbrirException ;

	Double cerrarMesa(Comanda comanda, Integer numeroDeMesa);

	Boolean cobrarComanda(Comanda comanda, Integer numeroMesa);

}
