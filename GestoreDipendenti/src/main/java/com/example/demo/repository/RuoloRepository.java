package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ruolo;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Long>{

}
