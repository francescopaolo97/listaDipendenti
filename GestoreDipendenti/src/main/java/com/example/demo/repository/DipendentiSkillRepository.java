package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ChiaveComposta;
import com.example.demo.model.DipendentiSkill;

@Repository
public interface DipendentiSkillRepository extends JpaRepository<DipendentiSkill, ChiaveComposta>{

}
