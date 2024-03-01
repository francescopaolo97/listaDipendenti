package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Dipendente;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Long>{

	Dipendente findByEmailAndPassword(String email, String password);

	List<Dipendente> findDipendenteByListaDipendentiSkill_Skill_Id(long idSkill);

}
