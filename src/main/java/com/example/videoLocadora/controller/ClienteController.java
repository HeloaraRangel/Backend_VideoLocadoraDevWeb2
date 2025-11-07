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

import com.example.videoLocadora.dto.ClienteDTO;
import com.example.videoLocadora.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
@CrossOrigin
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<ClienteDTO> listarTodos(){
		return clienteService.listarTodos();
	}
	
	@PostMapping
	public void inserir(@RequestBody ClienteDTO cliente) {
		clienteService.inserir(cliente);
		
	}
	
	@PutMapping
	public ClienteDTO alterar(@RequestBody ClienteDTO cliente) {
		return clienteService.alterar(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		clienteService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
}
