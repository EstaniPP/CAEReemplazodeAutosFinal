package comportamental;

import java.util.ArrayList;

public class CostosAno {
	private Integer ano;
	private ArrayList<Float> costos;
	private Float precioReventa;
	
	public CostosAno(Integer ano) {
		this.ano = ano;
		costos = new ArrayList<Float>();
		precioReventa = 0.0f;
	}
	
	public Integer getAno() {
		return ano;
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
