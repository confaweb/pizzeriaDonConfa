package ar.com.pizzeriaDonConfa.dominio.CartaMenu;

import ar.com.pizzeriaDonConfa.enums.Tamanio;
import ar.com.pizzeriaDonConfa.enums.Tipo;

public class Principal extends  Item{

	public Principal(String codigoItem, String descripcion, Double precio, Tamanio tamanio, Tipo tipo) {
		super( codigoItem,  descripcion,  precio,  tamanio,  tipo);

	}

}
