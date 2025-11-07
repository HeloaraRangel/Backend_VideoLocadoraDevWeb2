package com.example.videoLocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.videoLocadora.dto.TituloDTO;
import com.example.videoLocadora.entity.TituloEntity;
import com.example.videoLocadora.repository.TituloRepository;

@Service
public class TituloService {
	
	@Autowired
	private TituloRepository tituloRepository;
	
	//Listar todos
	public List<TituloDTO> listarTodos(){
		List<TituloEntity> titulos = tituloRepository.findAll();
	    return titulos.stream().map(TituloDTO::new).toList();	
	}
	
	//inserir - criar
	public void inserir(TituloDTO titulo) {
		TituloEntity tituloEntity = new TituloEntity(titulo);
		tituloRepository.save(tituloEntity);
	}
	
	//alterar
	public TituloDTO alterar(TituloDTO titulo) {
		TituloEntity tituloEntity = new TituloEntity(titulo);
		return new TituloDTO(tituloRepository.save(tituloEntity));
	}
	
	//excluir
	public void excluir(Long id) {
		TituloEntity titulo = tituloRepository.findById(id).get();
	    tituloRepository.delete(titulo);
	}
	
	//buscar por id
	public TituloDTO buscarPorId(Long id) {
		return new TituloDTO(tituloRepository.findById(id).get());
	}
}
