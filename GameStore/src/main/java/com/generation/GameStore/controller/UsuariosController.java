package com.generation.GameStore.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.GameStore.model.*;
import com.generation.GameStore.repository.UsuariosRepository;
import com.generation.GameStore.service.UsuarioService;

@RestController
@CrossOrigin ( origins  =   " * " , allowedHeaders  =  " * " )
@RequestMapping ("/usuarios")
public class UsuariosController<PostagemModel> {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuariosRepository usuarioRepository;
	
	
	@GetMapping("/all")
	 public  ResponseEntity < List< Usuarios > > getAll (){
        return  ResponseEntity.ok(usuarioRepository . findAll());
    }
	
	@PostMapping("/login")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user){
		return usuarioService.autenticarUsuario(user)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuarios> postUsuario(@Valid @RequestBody Usuarios usuario){
		return usuarioService.cadastrarUsuario(usuario)
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
		
	}
	
}
	
	
