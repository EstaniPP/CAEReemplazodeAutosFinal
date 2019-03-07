package comportamental;

import java.util.ArrayList;

public class Auto {
	private String nombreAuto;
	private Float inversionInicial;
	private Integer duracion;
	private ArrayList<CostosAño> costosAnuales;
	
	public Auto(String nombreAuto, Float inversionInicial, Integer duracion) {
		this.nombreAuto = nombreAuto;
		this.inversionInicial = inversionInicial;
		this.duracion = duracion;
		costosAnuales = new ArrayList<CostosAño>();
		for(int i=0;i<duracion;i++) {
			costosAnuales.add(i, new CostosAño(i));
		}
	}
	
	public void agregarCosto(Integer año, Float valor) {
		costosAnuales.get(año).agregarCosto(valor);
	}
	
	public Float getPrecioReventa(Integer año) {
		return costosAnuales.get(año).getPrecioReventa();
	}
	
	public void setPrecioReventa(Integer año, Float valor) {
		costosAnuales.get(año).setPrecioReventa(valor);
	}
	
	public ArrayList<Float> getCostos(int año){
		return costosAnuales.get(año).getCostos();
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
