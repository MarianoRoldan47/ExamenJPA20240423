package examen.controllers;

import examen.models.Usuario;

public class ControladorUsuario  extends SuperControlador {
	private static ControladorUsuario instance = null;
	
	public ControladorUsuario() {
		super("usuario", Usuario.class);
	}
	
	public static ControladorUsuario getInstance() {
		if(instance==null) {
			instance = new ControladorUsuario();
		}
		return instance;
	}
	
	public Usuario find(Integer id) {
		return(Usuario) getEntityManager().find(Usuario.class, id);
	}
}
