package comportamental;

import java.util.ArrayList;

public class CostosA�o {
	private Integer a�o;
	private ArrayList<Float> costos;
	private Float precioReventa;
	
	public CostosA�o(Integer a�o) {
		this.a�o = a�o;
		costos = new ArrayList<Float>();
		precioReventa = 0.0f;
	}
	
	public Integer getA�o() {
		return a�o;
	}
	
	public ArrayList<Float> getCostos() {
		return costos;
	}
	
	public Float getPrecioReventa() {
		return precioReventa;
	}
	
	public void setPrecioReventa(Float precioReventa) {
		this.precioReventa = precioReventa;
	}
	
	public void agregarCosto(Float costo) {
		costos.add(costo);
	}
}
