package com.example.videoLocadora.dto;

import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.entity.TituloEntity;


public class TituloDTO {
	
	private Long id;
	private String nome;
	private int ano;
	private String sinopse;
	private String categoria;
	
	//para converter de entity para dto 
	public TituloDTO(TituloEntity titulo) {
		BeanUtils.copyProperties(titulo, this);
	}
	
	//construtor
	public TituloDTO() {
			
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

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
