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

import com.example.videoLocadora.dto.ClasseDTO;
import com.example.videoLocadora.service.ClasseService;

@RestController
@RequestMapping(value = "/classe")
@CrossOrigin
public class ClasseController {
	
	@Autowired
	private ClasseService classeService;
	
	@GetMapping
	public List<ClasseDTO> listarTodos(){
		return classeService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ClasseDTO buscarAtor(@PathVariable Long id){
		return classeService.buscarPorId(id);
	}
	
	@PostMapping
	public void inserir(@RequestBody ClasseDTO classe) {
		classeService.inserir(classe);
		
	}
	
	@PutMapping
	public ClasseDTO alterar(@RequestBody ClasseDTO classe) {
		return classeService.alterar(classe);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		classeService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
