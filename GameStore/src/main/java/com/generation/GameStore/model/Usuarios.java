package com.generation.GameStore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table ( name = "tb_usuario")
public class Usuarios {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@NotNull
@Size(min = 5, max = 125)
private String nome;
@NotNull
@Size(min = 8, max = 40)
private String usuario;
@NotNull
@Size(min = 6, max = 100)
private String senha;


public Usuarios(Long id, String nome, String senha, String usuario) {
	this.id = id;
    this.nome = nome;
    this.usuario = usuario;
    this.senha = senha;

}
public Usuarios() {
	
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	nome = nome;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}




}
