package mongoDB.controladores;

import java.text.SimpleDateFormat;
import java.util.List;

import mongoDB.model.Provincia;





public class DatosDeTabla {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static String[] getTitulosColumnas() {
		return new String[] {"code", "label", "parent_code"};
	}
	
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		@SuppressWarnings("unchecked")
		List<Provincia> provincias =(List<Provincia>) ControladorProvincia.getAllCcaa(ControladorProvincia.getMongoCollectionProvincia());
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[provincias.size()][3];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < provincias.size(); i++) {
			Provincia provincia = provincias.get(i);
			datos[i][0]=provincia.getCode();
			datos[i][1]=provincia.getLabel();
			datos[i][2]=provincia.getParent_code();
			
			
		}
		
		return datos;
	}

}
