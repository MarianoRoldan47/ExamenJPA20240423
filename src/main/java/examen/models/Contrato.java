package examen.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "contrato")
public class Contrato extends Entidad {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	private String descripcion;
	private float saldo;
	private float limite;
	@ManyToOne
	@JoinColumn(name = "idTipoContrato")
	private TipoContrato tipoContrato;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	private Date fechaFirma;
	
	
	public Contrato() {
		super();
	}
	
	
	public Contrato(int id, String descripcion, float saldo, float limite, TipoContrato idTipoContrato,
			Usuario idUsuario, Date fechaFirma) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.saldo = saldo;
		this.limite = limite;
		this.tipoContrato = idTipoContrato;
		this.usuario = idUsuario;
		this.fechaFirma = fechaFirma;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public float getLimite() {
		return limite;
	}
	public void setLimite(float limite) {
		this.limite = limite;
	}
	public TipoContrato getIdTipoContrato() {
		return tipoContrato;
	}
	public void setIdTipoContrato(TipoContrato idTipoContrato) {
		this.tipoContrato = idTipoContrato;
	}
	public Usuario getIdUsuario() {
		return usuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		this.usuario = idUsuario;
	}
	public Date getFechaFirma() {
		return fechaFirma;
	}
	public void setFechaFirma(Date fechaFirma) {
		this.fechaFirma = fechaFirma;
	}
	
	
}
