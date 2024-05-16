package examen.controllers;

import examen.models.Contrato;

public class ControladorContrato extends SuperControlador {
	
		private static ControladorContrato instance = null;
		
		public ControladorContrato() {
			super("contrato", Contrato.class);
		}
		
		public static ControladorContrato getInstance() {
			if(instance==null) {
				instance = new ControladorContrato();
			}
			return instance;
		}
		
		public Contrato find(Integer id) {
			return(Contrato) getEntityManager().find(Contrato.class, id);
		}
		
		
}
