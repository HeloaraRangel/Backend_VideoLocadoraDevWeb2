package com.example.videoLocadora.dto;

import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.entity.DiretorEntity;

public class DiretorDTO {
	
	private Long id;
	private String nome;
	
	//para converter de entity para dto 
	public DiretorDTO(DiretorEntity diretor) {
		BeanUtils.copyProperties(diretor, this);
	}
		
	//construtor
	public DiretorDTO() {
			
	}
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
