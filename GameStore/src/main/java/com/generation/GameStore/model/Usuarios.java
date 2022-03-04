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
private String Nome;
@NotNull
@Size(min = 8, max = 40)
private String usuario;
@NotNull
@Size(min = 6, max = 100)
private String senha;

}
