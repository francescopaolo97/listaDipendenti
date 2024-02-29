package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String competenza;
	
	@OneToMany(mappedBy = "skill")
	private List<DipendentiSkill> listaDipendentiSkill;

	public Skill() {
		super();
	}

	public Skill(long id, String competenza, List<DipendentiSkill> listaDipendentiSkill) {
		super();
		this.id = id;
		this.competenza = competenza;
		this.listaDipendentiSkill = listaDipendentiSkill;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompetenza() {
		return competenza;
	}

	public void setCompetenza(String competenza) {
		this.competenza = competenza;
	}

	public List<DipendentiSkill> getListaDipendentiSkill() {
		return listaDipendentiSkill;
	}

	public void setListaDipendentiSkill(List<DipendentiSkill> listaDipendentiSkill) {
		this.listaDipendentiSkill = listaDipendentiSkill;
	}
}
