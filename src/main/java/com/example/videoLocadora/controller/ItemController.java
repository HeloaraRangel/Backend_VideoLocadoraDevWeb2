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

import com.example.videoLocadora.dto.ItemDTO;
import com.example.videoLocadora.service.ItemService;

@RestController
@RequestMapping(value = "/item")
@CrossOrigin
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public List<ItemDTO> item(){
		return itemService.listarTodos();
	}
	
	@PostMapping
	public void inserir(@RequestBody ItemDTO item) {
		itemService.inserir(item);
		
	}
	
	@PutMapping
	public ItemDTO alterar(@RequestBody ItemDTO item) {
		return itemService.alterar(item);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		itemService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
}
