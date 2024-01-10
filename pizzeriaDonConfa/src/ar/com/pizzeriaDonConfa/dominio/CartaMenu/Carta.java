package ar.com.pizzeriaDonConfa.dominio.CartaMenu;

import java.util.HashMap;
import java.util.Map;

import ar.com.pizzeriaDonConfa.enums.Categoria;
import ar.com.pizzeriaDonConfa.enums.Tipo;
import ar.com.pizzeriaDonConfa.exception.ItemInexistenteException;
import ar.com.pizzeriaDonConfa.interfaces.AdministadorCarta;

public class Carta implements AdministadorCarta {
	private Map<String, Bebida> cartaBebidas;
	private Map<String, Principal> cartaPrincipal;
	private Map<String, Postre> cartaPostre;

	public Carta(Categoria categoria) {
		this.cartaBebidas = new HashMap<String, Bebida>();
		this.cartaPostre = new HashMap<String, Postre>();
		this.cartaPrincipal = new HashMap<String, Principal>();

	}

	public Map<String, Bebida> getCartaBebidas() {
		return cartaBebidas;
	}

	public void setCartaBebidas(Map<String, Bebida> cartaBebidas) {
		this.cartaBebidas = cartaBebidas;
	}

	public Map<String, Principal> getCartaPrincipal() {
		return cartaPrincipal;
	}

	public void setCartaPrincipal(Map<String, Principal> cartaPrincipal) {
		this.cartaPrincipal = cartaPrincipal;
	}

	public Map<String, Postre> getCartaPostre() {
		return cartaPostre;
	}

	public void setCartaPostre(Map<String, Postre> cartaPostre) {
		this.cartaPostre = cartaPostre;
	}

	@Override
	public void agregarItem(Item item) {

		if (item.getTipo().equals(Tipo.PRINCIPAL)) {

			cartaPrincipal.put(item.getCodigoItem(), (Principal) item);

		}

		else if (item.getTipo().equals(Tipo.BEBIDAS)) {
			cartaBebidas.put(item.codigoItem, (Bebida) item);

		}

		else if (item.getTipo().equals(Tipo.POSTRE)) {
			cartaPostre.put(item.codigoItem, (Postre) item);

		}

	}

	@Override
	public void borrarItem(String codigo) throws ItemInexistenteException {
		if (cartaBebidas.containsKey(codigo))
			cartaBebidas.remove(codigo);
		else if (cartaPostre.containsKey(codigo))
			cartaPostre.remove(codigo);
		else if (cartaPrincipal.containsKey(codigo))
			cartaPrincipal.remove(codigo);
		else
			throw new ItemInexistenteException("Item inexistente");

	}

	@Override
	public void cambiarPrecio(Item item,Double precio) {
		item.setPrecio(precio);

	}

}
