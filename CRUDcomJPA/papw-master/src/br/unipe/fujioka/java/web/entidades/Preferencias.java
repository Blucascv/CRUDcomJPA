package br.unipe.fujioka.java.web.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Preferencias {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="preferencias_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String preferencia;
	
	/*@JoinTable(name="PREF_CLIE",
			  joinColumns=@JoinColumn(name="PREF_ID"),
			  inverseJoinColumns=@JoinColumn(name="CLIE_ID"))*/
	
	//@ManyToOne
	//private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	/*public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}*/

}