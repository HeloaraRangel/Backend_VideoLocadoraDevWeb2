package com.example.videoLocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.videoLocadora.dto.AtorDTO;
import com.example.videoLocadora.entity.AtorEntity;
import com.example.videoLocadora.exceptions.NaoEncontradoException;
import com.example.videoLocadora.repository.AtorRepository;

@Service
public class AtorService {
	
	@Autowired
	private AtorRepository atorRepository;
	
	//Listar todos
	public List<AtorDTO> listarTodos(){
		List<AtorEntity> atores = atorRepository.findAll();
	    return atores.stream().map(AtorDTO::new).toList();	
	}
	
	//inserir - criar
	public void inserir(AtorDTO ator) {
		AtorEntity atorEntity = new AtorEntity(ator);
		atorRepository.save(atorEntity);
	}
	
	//alterar
	public AtorDTO alterar(AtorDTO ator) {
		AtorEntity atorEntity = new AtorEntity(ator);
		return new AtorDTO(atorRepository.save(atorEntity));
	}
	
	//excluir
	public void excluir(Long id) {
		AtorEntity ator = atorRepository.findById(id).get();
	    atorRepository.delete(ator);
	}
	
	public AtorDTO buscarPorId(Long id) {
	    AtorEntity ator = atorRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Ator não encontrado com o ID: " + id));

	    return new AtorDTO(ator);
	}

	
}
