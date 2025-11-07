package com.example.videoLocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.videoLocadora.dto.DiretorDTO;
import com.example.videoLocadora.entity.DiretorEntity;
import com.example.videoLocadora.repository.DiretorRepository;

@Service
public class DiretorService {
	@Autowired
	private DiretorRepository diretorRepository;
	
	//Listar todos
	public List<DiretorDTO> listarTodos(){
		List<DiretorEntity> diretores = diretorRepository.findAll();
	    return diretores.stream().map(DiretorDTO::new).toList();	
	}
	
	//inserir - criar
	public void inserir(DiretorDTO diretor) {
		DiretorEntity atorEntity = new DiretorEntity(diretor);
		diretorRepository.save(atorEntity);
	}
	
	//alterar
	public DiretorDTO alterar(DiretorDTO diretor) {
		DiretorEntity diretorEntity = new DiretorEntity(diretor);
		return new DiretorDTO(diretorRepository.save(diretorEntity));
	}
	
	//excluir
	public void excluir(Long id) {
		DiretorEntity diretor = diretorRepository.findById(id).get();
		diretorRepository.delete(diretor);
	}
	
	//buscar por id
	public DiretorDTO buscarPorId(Long id) {
		return new DiretorDTO(diretorRepository.findById(id).get());
	}
}
