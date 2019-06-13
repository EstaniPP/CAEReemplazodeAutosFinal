package comportamental;

import java.util.ArrayList;

public class CostosAño {
	private Integer año;
	private ArrayList<Float> costos;
	private Float precioReventa;
	
	public CostosAño(Integer año) {
		this.año = año;
		costos = new ArrayList<Float>();
		precioReventa = 0.0f;
	}
	
	public Integer getAño() {
		return año;
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
