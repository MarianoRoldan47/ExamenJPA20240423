package examen.controllers;

import java.util.List;

import examen.models.Contrato;




public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"id", "descripcion", "saldo", "limite", "idTipoContrato", "idUsuario", "fechaFirma"};
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Contrato> contratos = (List<Contrato>) ControladorContrato.getInstance().findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[contratos.size()][10];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < contratos.size(); i++) {
			Contrato e = contratos.get(i);
			datos[i][0] = e.getId();
			datos[i][1] = e.getDescripcion();
			datos[i][2] = e.getSaldo();
			datos[i][3] = e.getLimite();
			datos[i][4] = e.getIdTipoContrato();
			datos[i][5] = e.getIdUsuario();
			datos[i][6] = e.getFechaFirma();
		}
		
		return datos;
	}
	
	
}
