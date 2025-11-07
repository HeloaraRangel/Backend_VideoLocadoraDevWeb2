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

import com.example.videoLocadora.dto.TituloDTO;
import com.example.videoLocadora.service.TituloService;


@RestController
@RequestMapping(value = "/titulo")
@CrossOrigin
public class TituloController {
	@Autowired
	private TituloService tituloService;
	
	@GetMapping
	public List<TituloDTO> listarTodos(){
		return tituloService.listarTodos();
	}
	
	@PostMapping
	public void inserir(@RequestBody TituloDTO titulo) {
		tituloService.inserir(titulo);
		
	}
	
	@PutMapping
	public TituloDTO alterar(@RequestBody TituloDTO titulo) {
		return tituloService.alterar(titulo);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		tituloService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
