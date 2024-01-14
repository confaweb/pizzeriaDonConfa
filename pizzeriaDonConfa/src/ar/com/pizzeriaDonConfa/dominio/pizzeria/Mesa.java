package ar.com.pizzeriaDonConfa.dominio.pizzeria;

import java.util.Objects;

import ar.com.pizzeriaDonConfa.enums.EstadoMesa;

public class Mesa implements Comparable<Mesa> {

	private Integer numeroMesa;
	private EstadoMesa estadoMesa;
	private Integer cantidadComensales;

	public Mesa(Integer numeroMesa, EstadoMesa estadoMesa, Integer cantidadComensales) {
		this.numeroMesa=numeroMesa;
		this.estadoMesa=estadoMesa;
		this.cantidadComensales=cantidadComensales;
				
	}

	public Integer getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public EstadoMesa getEstadoMesa() {
		return estadoMesa;
	}

	public void setEstadoMesa(EstadoMesa estadoMesa) {
		this.estadoMesa = estadoMesa;
	}

	public Integer getCantidadComensales() {
		return cantidadComensales;
	}

	public void setCantidadComensales(Integer cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroMesa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		return Objects.equals(numeroMesa, other.numeroMesa);
	}

	@Override
	public String toString() {
		return "Mesa [numeroMesa=" + numeroMesa + ", estadoMesa=" + estadoMesa + ", cantidadComensales="
				+ cantidadComensales + "]";
	}

	@Override
	public int compareTo(Mesa m) {
		
		return this.numeroMesa-m.getNumeroMesa();
	}

}
