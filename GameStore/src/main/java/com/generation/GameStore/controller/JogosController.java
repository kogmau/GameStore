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

import com.generation.GameStore.model.Jogos;
import com.generation.GameStore.repository.JogosRepository;
 
@RestController
@CrossOrigin ( origins  =   " * " , allowedHeaders  =  " * " )
@RequestMapping ("/jogos")
public class JogosController {
	@Autowired
	private JogosRepository repository;
	
	@GetMapping
	public List<Jogos> GetAll(){
		return repository.findAll();
	}

	@GetMapping("/{id}")
    public ResponseEntity<Jogos> GetById(@PathVariable long id) {
    	return repository.findById(id)
    			.map(resp -> ResponseEntity.ok(resp))
    			.orElse(ResponseEntity.notFound().build());
    	}


	@GetMapping("/nome/{nome}")
    public ResponseEntity<List<Jogos>> getByName(@PathVariable String nome){
	 return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
 }
	

	@GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Jogos>> getBydescricao(@PathVariable String descricao){
	 return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
 }
	
    @PostMapping
    public ResponseEntity<Jogos> post (@RequestBody Jogos jogos) {
	return ResponseEntity.status(HttpStatus.CREATED)
			.body(repository.save(jogos));
}
 
    @PutMapping
    public ResponseEntity<Jogos> put (@RequestBody Jogos jogos){
	 return ResponseEntity.ok(repository.save(jogos));
	 
 }
 
    
    
   @DeleteMapping("/{id}")
   public void delete(@PathVariable long id) {
	 repository.deleteById(id);

}
	
}
