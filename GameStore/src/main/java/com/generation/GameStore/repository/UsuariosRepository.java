package com.generation.GameStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.GameStore.model.Usuarios;


public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
	public List<Usuarios> findAllByDescricaoContainingIgnoreCase(String usuario);
}