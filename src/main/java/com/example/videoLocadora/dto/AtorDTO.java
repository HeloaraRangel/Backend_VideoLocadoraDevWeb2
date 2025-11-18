package com.example.videoLocadora.dto;


import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.entity.AtorEntity;

public class AtorDTO {
	
	private Long id;
	private String nome;
	
	//para converter de entity para dto 
	public AtorDTO(AtorEntity ator) {
		BeanUtils.copyProperties(ator, this);
	}
	
	//construtor
	public AtorDTO() {
		
	}
	
	//gets e sets
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
