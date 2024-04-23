package examen.controllers;

import examen.models.TipoContrato;

public class ControladorTipoContrato extends SuperControlador {

	private static ControladorTipoContrato instance = null;

	public ControladorTipoContrato() {
		super("tipocontrato", TipoContrato.class);
	}

	public static ControladorTipoContrato getInstance() {
		if (instance == null) {
			instance = new ControladorTipoContrato();
		}
		return instance;
	}
	
	public TipoContrato find(Integer id) {
		return(TipoContrato) getEntityManager().find(TipoContrato.class, id);
	}
}
