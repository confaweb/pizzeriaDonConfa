package ar.com.pizzeriaDonConfa.interfaces;

import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Item;
import ar.com.pizzeriaDonConfa.exception.ItemInexistenteException;

public interface AdministadorCarta {
	void agregarItem(Item item);
	void borrarItem(String codigo) throws ItemInexistenteException;
	void cambiarPrecio(Item item,Double precio);
	

}
