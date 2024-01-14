package ar.com.pizzeriaDonConfa.dominio.CartaMenu;

import java.util.Objects;

import ar.com.pizzeriaDonConfa.enums.Tamanio;
import ar.com.pizzeriaDonConfa.enums.Tipo;

public class Item {
	protected String descripcion;
	protected String codigoItem;
	protected Double precio;
	protected Tamanio tamanio;
	protected Tipo tipo;

	public Item(String descripcion2, Tipo tipo2) {

	}

	public Item(String codigoItem, String descripcion, Double precio, Tamanio tamanio, Tipo tipo) {
		this.codigoItem = codigoItem;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tamanio = tamanio;
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoItem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(codigoItem, other.codigoItem);
	}

	@Override
	public String toString() {
		return "Item [descripcion=" + descripcion + ", codigoItem=" + codigoItem + ", precio=" + precio + ", tamanio="
				+ tamanio + ", tipo=" + tipo + "]";
	}

}
