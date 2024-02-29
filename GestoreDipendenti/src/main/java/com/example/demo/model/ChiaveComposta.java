package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ChiaveComposta implements Serializable{


	private static final long serialVersionUID = 1L;

	@Column(name = "id_dipendente")
	private long idDipendente;
	
	@Column(name = "id_skill")
	private long idSkill;

	public ChiaveComposta() {
		super();
	}

	public ChiaveComposta(long idDipendente, long idSkill) {
		super();
		this.idDipendente = idDipendente;
		this.idSkill = idSkill;
	}

	public long getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(long idDipendente) {
		this.idDipendente = idDipendente;
	}

	public long getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(long idSkill) {
		this.idSkill = idSkill;
	}
}
