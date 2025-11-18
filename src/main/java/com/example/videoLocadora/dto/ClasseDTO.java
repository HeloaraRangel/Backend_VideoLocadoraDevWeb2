package com.example.videoLocadora.dto;


import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.entity.ClasseEntity;


public class ClasseDTO {
	
	private Long id;
	private String nome;
	private double valor;
	private int prazoDevolucao;
	
	//para converter de entity para dto 
	public ClasseDTO(ClasseEntity classe) {
		BeanUtils.copyProperties(classe, this);
	}
	
	//construtor
	public ClasseDTO() {
		
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
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getPrazoDevolucao() {
		return prazoDevolucao;
	}

	public void setPrazoDevolucao(int prazoDevolucao) {
		this.prazoDevolucao = prazoDevolucao;
	}

}
