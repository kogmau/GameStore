package com.generation.GameStore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.GameStore.model.Usuarios;


public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
	public List<Usuarios> findAllByUsuarioContainingIgnoreCase(String usuario);
	public Object findAllBynomeContainingIgnoreCase(String nome);
	public Optional<Usuarios> findByUsuario(String usuario);
}