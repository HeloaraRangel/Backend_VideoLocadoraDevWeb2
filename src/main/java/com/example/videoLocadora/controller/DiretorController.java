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

import com.example.videoLocadora.dto.DiretorDTO;
import com.example.videoLocadora.service.DiretorService;

@RestController
@RequestMapping(value = "/diretor")
@CrossOrigin
public class DiretorController {
	
	@Autowired
	private DiretorService diretorService;
	
	@GetMapping
	public List<DiretorDTO> listarTodos(){
		return diretorService.listarTodos();
	}
	
	@PostMapping
	public void inserir(@RequestBody DiretorDTO diretor) {
		diretorService.inserir(diretor);
		
	}
	
	@PutMapping
	public DiretorDTO alterar(@RequestBody DiretorDTO diretor) {
		return diretorService.alterar(diretor);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		diretorService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
}
