package examen.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import examen.models.Entidad;



public class SuperControlador {
	private EntityManager em = null;
	protected String nombreTabla = "";
	protected Class tipoEntidad;
	
	
	
	
	
	public SuperControlador(String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}

	/**
	 * 
	 * @return
	 */
	public EntityManager getEntityManager() {
		if (em == null) {
			em = Persistence.createEntityManagerFactory("bankonter").createEntityManager();
		}
		return em;

	}
	
	@SuppressWarnings("unchecked")
	public List<? extends Entidad> findAll () {
		return (List<Entidad>) getEntityManager().createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad).getResultList();
	}
	
	public Entidad findPrimero () {
		return (Entidad) getEntityManager().createNativeQuery("SELECT * FROM " + this.nombreTabla +" limit 1", this.tipoEntidad).getSingleResult();
	}
	
	public Entidad findUltimo () {
		return (Entidad) getEntityManager().createNativeQuery("SELECT * FROM " + this.nombreTabla + " order by id desc"+" limit 1", this.tipoEntidad).getSingleResult();
	}
	
	public Entidad findSiguiente(int id) {
		try {
			return (Entidad) getEntityManager().createNativeQuery("SELECT * FROM " + this.nombreTabla + " where  id>" + id+" limit 1", this.tipoEntidad).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Entidad findAnterior(int id) {		 
		try {
	        return (Entidad) getEntityManager().createNativeQuery("SELECT * FROM " + this.nombreTabla + " where  id<" + id +" order by id desc limit 1", this.tipoEntidad).getSingleResult();
	    } catch (NoResultException e) {
	        
	        return null;
	    }
	}

	public void actualizacion(Entidad e) {
		EntityManager em = getEntityManager();

		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	public void insercion(Entidad e) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public void eliminacion(Entidad e) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
	}
}
