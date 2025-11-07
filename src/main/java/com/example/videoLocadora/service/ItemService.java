package com.example.videoLocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.videoLocadora.dto.ItemDTO;
import com.example.videoLocadora.entity.ItemEntity;
import com.example.videoLocadora.repository.ItemRepository;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	//Listar todos
	public List<ItemDTO> listarTodos(){
		List<ItemEntity> itens = itemRepository.findAll();
	    return itens.stream().map(ItemDTO::new).toList();	
	}
	
	//inserir - criar
	public void inserir(ItemDTO item) {
		ItemEntity itemEntity = new ItemEntity(item);
		itemRepository.save(itemEntity);
	}
	
	//alterar
	public ItemDTO alterar(ItemDTO item) {
		ItemEntity itemEntity = new ItemEntity(item);
		return new ItemDTO(itemRepository.save(itemEntity));
	}
	
	//excluir
	public void excluir(Long id) {
		ItemEntity item = itemRepository.findById(id).get();
	    itemRepository.delete(item);
	}
	
	//buscar por id
	public ItemDTO buscarPorId(Long id) {
		return new ItemDTO(itemRepository.findById(id).get());
	}
}
