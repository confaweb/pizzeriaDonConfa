package ar.com.pizzeriaDonConfa.dominio.pizzeria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import ar.com.pizzeriaDonConfa.dominio.CartaMenu.Item;
import ar.com.pizzeriaDonConfa.enums.EstadoComanda;

public class Comanda implements Comparable<Comanda> {

	private Integer numeroMesa;
	private EstadoComanda estadoComanda;
	private Double montoTotal;
	private List<Double> cuenta; 
	private Map<String,Double> factura; 
	
	public Comanda(Integer numeroMesa, EstadoComanda estadoComanda, Double montoTotal) {
		this.numeroMesa= numeroMesa;
		this.estadoComanda=estadoComanda;
		this.montoTotal=montoTotal;
		this.cuenta=new ArrayList<Double>(); 
		this.factura=new HashMap<String,Double>();
	}

	public Integer getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public EstadoComanda getEstadoComanda() {
		return estadoComanda;
	}

	public void setEstadoComanda(EstadoComanda estadoComanda) {
		this.estadoComanda = estadoComanda;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public List<Double> getCuenta() {
		return cuenta;
	}

	public void setCuenta(List<Double> cuenta) {
		this.cuenta = cuenta;
	}

	public Map<String, Double> getFactura() {
		return factura;
	}

	public void setFactura(Map<String, Double> factura) {
		this.factura = factura;
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
		Comanda other = (Comanda) obj;
		return Objects.equals(numeroMesa, other.numeroMesa);
	}

	@Override
	public String toString() {
		return "Comanda [numeroMesa=" + numeroMesa + ", estadoComanda=" + estadoComanda + ", montoTotal=" + montoTotal
				+ "]";
	}

	@Override
	public int compareTo(Comanda c) {
		
		return (int) (this.montoTotal-c.getMontoTotal());
	}

	public Boolean agregarItem(Item seleccion) {
		
		Boolean agregado=false;
		agregado=this.cuenta.add(seleccion.getPrecio());
		this.factura.put(seleccion.getDescripcion(),seleccion.getPrecio());
		return agregado;
	}
	

}
