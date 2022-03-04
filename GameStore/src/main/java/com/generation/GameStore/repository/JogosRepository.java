package com.generation.GameStore.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.GameStore.model.Jogos;


public interface JogosRepository extends JpaRepository<Jogos, Long>{
	public List<Jogos> findAllByDescricaoContainingIgnoreCase(String Jogos);
}