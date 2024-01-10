package ar.com.pizzeriaDonConfa.dominio.CartaMenu;

import ar.com.pizzeriaDonConfa.enums.Tamanio;
import ar.com.pizzeriaDonConfa.enums.Tipo;

public class Postre extends  Item{
	public Postre(String codigoItem, String descripcion, Double precio, Tamanio tamanio, Tipo tipo) {
		super( codigoItem,  descripcion,  precio,  tamanio,  tipo);

	}


}
