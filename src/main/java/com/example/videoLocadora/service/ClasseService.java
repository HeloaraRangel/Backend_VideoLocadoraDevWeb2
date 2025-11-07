package com.example.videoLocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.videoLocadora.dto.ClasseDTO;
import com.example.videoLocadora.entity.ClasseEntity;
import com.example.videoLocadora.exceptions.NaoEncontradoException;
import com.example.videoLocadora.repository.ClasseRepository;

@Service
public class ClasseService {
	
	@Autowired
	private ClasseRepository classeRepository;
	
	//Listar todos
	public List<ClasseDTO> listarTodos(){
		List<ClasseEntity> classes = classeRepository.findAll();
		return classes.stream().map(ClasseDTO::new).toList();	
	}
		
	//inserir - criar
	public void inserir(ClasseDTO classe) {
		ClasseEntity classeEntity = new ClasseEntity(classe);
		classeRepository.save(classeEntity);
	}
		
	//alterar
	public ClasseDTO alterar(ClasseDTO classe) {
		ClasseEntity classeEntity = new ClasseEntity(classe);
		return new ClasseDTO(classeRepository.save(classeEntity));
	}
		
	//excluir
	public void excluir(Long id) {
		ClasseEntity classe = classeRepository.findById(id).get();
		classeRepository.delete(classe);
	}
		
	//buscar por id
	/*public ClasseDTO buscarPorId(Long id) {
		return new ClasseDTO(classeRepository.findById(id).get());
	}*/
	
	public ClasseDTO buscarPorId(Long id) {
	    ClasseEntity classe = classeRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Classe não encontrado com o ID: " + id));

	    return new ClasseDTO(classe);
	}
}
