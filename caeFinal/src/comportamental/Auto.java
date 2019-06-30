package comportamental;

import java.util.ArrayList;

public class Auto {
	private String nombreAuto;
	private Float inversionInicial;
	private Integer duracion;
	private ArrayList<CostosAno> costosAnuales;
	
	public Auto(String nombreAuto, Float inversionInicial, Integer duracion) {
		this.nombreAuto = nombreAuto;
		this.inversionInicial = inversionInicial;
		this.duracion = duracion;
		costosAnuales = new ArrayList<CostosAno>();
		for(int i=0;i<duracion;i++) {
			costosAnuales.add(i, new CostosAno(i));
		}
	}
	
	public void agregarCosto(Integer ano, Float valor) {
		costosAnuales.get(ano).agregarCosto(valor);
	}
	
	public Float getPrecioReventa(Integer ano) {
		return costosAnuales.get(ano).getPrecioReventa();
	}
	
	public void setPrecioReventa(Integer ano, Float valor) {
		costosAnuales.get(ano).setPrecioReventa(valor);
	}
	
	public ArrayList<Float> getCostos(int ano){
		return costosAnuales.get(ano).getCostos();
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
