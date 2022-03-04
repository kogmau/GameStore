package com.generation.GameStore.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table (name="tb_jogos")
public class Jogos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	@NotBlank
	@Size(min=3, max=5)
	private String nome;
	
	@NotBlank
	@Size(min=3,max=5)
	private String descricao;
	
	@NotBlank
	@Size(min=3,max=5)
	private String Plataforma;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPlataforma() {
		return Plataforma;
	}

	public void setPlataforma(String plataforma) {
		Plataforma = plataforma;
	}

	public String getIdade() {
		return Idade;
	}

	public void setIdade(String idade) {
		Idade = idade;
	}

	@NotBlank
	@Size(min=3,max=5)
	private String Idade;
	
	@NotBlank
	private BigDecimal preco;

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
		this.nome = nome;
	}


	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	
}
