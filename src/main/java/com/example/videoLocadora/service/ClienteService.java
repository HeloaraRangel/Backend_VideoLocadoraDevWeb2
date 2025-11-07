package com.example.videoLocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.videoLocadora.dto.ClienteDTO;
import com.example.videoLocadora.entity.ClienteEntity;
import com.example.videoLocadora.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	//Listar todos
	public List<ClienteDTO> listarTodos(){
		List<ClienteEntity> clientes = clienteRepository.findAll();
		   return clientes.stream().map(ClienteDTO::new).toList();	
	}
		
	//inserir - criar
	public void inserir(ClienteDTO cliente) {
		ClienteEntity clienteEntity = new ClienteEntity(cliente);
		clienteRepository.save(clienteEntity);
	}
		
	//alterar
	public ClienteDTO alterar(ClienteDTO cliente) {
		ClienteEntity clienteEntity = new ClienteEntity(cliente);
		return new ClienteDTO(clienteRepository.save(clienteEntity));
	}
		
	//excluir
	public void excluir(Long id) {
		ClienteEntity cliente = clienteRepository.findById(id).get();
		clienteRepository.delete(cliente);
	}
		
	//buscar por id
	public ClienteDTO buscarPorId(Long id) {
		return new ClienteDTO(clienteRepository.findById(id).get());
	}
}
