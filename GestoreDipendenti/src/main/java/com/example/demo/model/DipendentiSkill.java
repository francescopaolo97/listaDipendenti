package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class DipendentiSkill {
	
	@EmbeddedId
	private ChiaveComposta id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_dipendente")
	@MapsId("idDipendente")
	private Dipendente dipendente;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_skill")
	@MapsId("idSkill")
	private Skill skill;
	
	private String livello;

	public DipendentiSkill() {
		super();
	}

	public DipendentiSkill(ChiaveComposta id, Dipendente dipendente, Skill skill, String livello) {
		super();
		this.id = id;
		this.dipendente = dipendente;
		this.skill = skill;
		this.livello = livello;
	}

	public ChiaveComposta getId() {
		return id;
	}

	public void setId(ChiaveComposta id) {
		this.id = id;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public String getLivello() {
		return livello;
	}

	public void setLivello(String livello) {
		this.livello = livello;
	}
}
