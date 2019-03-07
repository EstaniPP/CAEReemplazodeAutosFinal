package comportamental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class CAE {

	public static Vector<Float> interesCompuesto = new Vector<Float>();
	public static boolean comienzo;
	
	public static float CAEAuto(Auto auto, Integer ano) {
		if(auto==null) {
			return 0;
		}
		if(comienzo == false) {
			float cae = (float) (auto.getInversionInicial() - (auto.getPrecioReventa(ano)/Math.pow((1+interesCompuesto.get(ano)/100),ano+1)));
			float sumatoria = 0;
			for(int i=0; i<ano+1; i++) {
				float sumasGastos = 0;
				ArrayList<Float> gastos = auto.getCostos(i);
				for(int j =0; j<gastos.size(); j++) {
					sumasGastos += gastos.get(j);
				}
				sumatoria += sumasGastos/Math.pow((1+interesCompuesto.get(ano)/100),i+1);
			}
			cae += sumatoria;
			float ajustedecapital = 1;
			if(interesCompuesto.get(ano) != 0)ajustedecapital =(float) ((Math.pow((1+interesCompuesto.get(ano)/100),ano+1)*interesCompuesto.get(ano)/100)/(Math.pow((1+interesCompuesto.get(ano)/100),ano+1)-1));
			cae = (float) (cae*ajustedecapital);
			return cae;
		}else {
			float cae = (float) (auto.getInversionInicial() - (auto.getPrecioReventa(ano)/Math.pow((1+interesCompuesto.get(ano)/100),ano)));
			float sumatoria = 0;
			for(int i=0; i<ano+1; i++) {
				float sumasGastos = 0;
				ArrayList<Float> gastos = auto.getCostos(i);
				for(int j =0; j<gastos.size(); j++) {
					sumasGastos += gastos.get(j);
				}
				sumatoria += sumasGastos/Math.pow((1+interesCompuesto.get(ano)/100),i);
			}
			cae += sumatoria;
			float ajustedecapital = 1;
			if(ano!=0) {
				if(interesCompuesto.get(ano) != 0)ajustedecapital =(float) ((Math.pow((1+interesCompuesto.get(ano)/100),ano)*interesCompuesto.get(ano)/100)/(Math.pow((1+interesCompuesto.get(ano)/100),ano)-1));
			}else {
				ajustedecapital = 1;
			}
			cae = (float) (cae*ajustedecapital);
			return cae;
		}
	}
	
	public static String mejorAuto(HashMap<String, Auto> autos) {
		if(autos.isEmpty()) {
			return "No hay ningun auto cargado aun, por favor ingrese alguno y vuelva a entrar";
		}else {
			Integer mejorano =0;
			Auto mejorauto = null;
			float CAEMejorauto = Float.MAX_VALUE;
			for(String key : autos.keySet()) {
				Auto aux = autos.get(key);
				for(int i=0; i<aux.getDuracion(); i++) {
					float CAEaux =CAE.CAEAuto(aux,i);
					if(CAEMejorauto > CAEaux) {
						CAEMejorauto = CAEaux;
						mejorauto = aux;
						mejorano = new Integer(i);
						System.out.println(i);
					}
				}
			}	
			return "En base al costo anual equivalente(CAE) se recomienda adquirir el auto "+mejorauto.getNombreAuto()+" ya que tiene un CAE de "+CAE.CAEAuto(mejorauto,mejorano)+" en el "+mejorano+" periodo("+new Integer(mejorano+1)+" año) el cual es el menor de todos";
		}
	}
}
