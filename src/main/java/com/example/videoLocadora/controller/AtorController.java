package com.example.videoLocadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.videoLocadora.dto.AtorDTO;
import com.example.videoLocadora.service.AtorService;

@RestController
@RequestMapping(value = "/ator")
//COLOCAR O ENDEREÇO
@CrossOrigin(origins="http://localhost:")
public class AtorController {
	
	@Autowired
	private AtorService atorService;
	
	@GetMapping
	public List<AtorDTO> listarTodos(){
		return atorService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public AtorDTO buscarAtor(@PathVariable Long id){
		return atorService.buscarPorId(id);
	}
	
	
	@PostMapping
	public void inserir(@RequestBody AtorDTO ator) {
		atorService.inserir(ator);
		
	}
	
	@PutMapping
	public AtorDTO alterar(@RequestBody AtorDTO ator) {
		return atorService.alterar(ator);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		atorService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	
}
