package com.generation.GameStore.controller;

import java.util.List;

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

@RestController
@CrossOrigin ( origins  =   " * " , allowedHeaders  =  " * " )
@RequestMapping ("/usuarios")
public class UsuariosController {
	@Autowired
	private UsuariosRepository repository;
	
	@GetMapping
	public List<Usuarios>GetAll(){
		return repository.findAll();
	}

	@GetMapping("/{id}")
    public ResponseEntity<Usuarios> GetById(@PathVariable long id) {
    	return repository.findById(id)
    			.map(resp -> ResponseEntity.ok(resp))
    			.orElse(ResponseEntity.notFound().build());
    	}

	
	@GetMapping("/nome/{nome}")
    public ResponseEntity<List<Usuarios>> getByName(@PathVariable String nome){
	 return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
 }
	

	
    @PostMapping
    public ResponseEntity<Usuarios> post (@RequestBody Usuarios usuarios) {
	return ResponseEntity.status(HttpStatus.CREATED)
			.body(repository.save(usuarios));
}
 
    @PutMapping
    public ResponseEntity<Usuarios> put (@RequestBody Usuarios usuarios){
	 return ResponseEntity.ok(repository.save(usuarios));
	 
 }
 
    
    
   @DeleteMapping("/{id}")
   public void delete(@PathVariable long id) {
	 repository.deleteById(id);

}
	
	
}
