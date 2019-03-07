package comportamental;

import java.util.ArrayList;

public class Auto {
	private String nombreAuto;
	private Float inversionInicial;
	private Integer duracion;
	private ArrayList<CostosA�o> costosAnuales;
	
	public Auto(String nombreAuto, Float inversionInicial, Integer duracion) {
		this.nombreAuto = nombreAuto;
		this.inversionInicial = inversionInicial;
		this.duracion = duracion;
		costosAnuales = new ArrayList<CostosA�o>();
		for(int i=0;i<duracion;i++) {
			costosAnuales.add(i, new CostosA�o(i));
		}
	}
	
	public void agregarCosto(Integer a�o, Float valor) {
		costosAnuales.get(a�o).agregarCosto(valor);
	}
	
	public Float getPrecioReventa(Integer a�o) {
		return costosAnuales.get(a�o).getPrecioReventa();
	}
	
	public void setPrecioReventa(Integer a�o, Float valor) {
		costosAnuales.get(a�o).setPrecioReventa(valor);
	}
	
	public ArrayList<Float> getCostos(int a�o){
		return costosAnuales.get(a�o).getCostos();
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public String getNombreAuto() {
		return nombreAuto;
	}
	
	public Float getInversionInicial() {
		return inversionInicial;
	}
	
	public void setInversionInicial(Float inversionInicial) {
		this.inversionInicial = inversionInicial;
	}
	
	public void setNombreAuto(String nombreAuto) {
		this.nombreAuto = nombreAuto;
	}
	
	@Override
	public String toString() {
		return "Nombre del auto "+nombreAuto+" con duracion de "+duracion+" y una inversion inicial de "+inversionInicial+".";
	}
	
}
