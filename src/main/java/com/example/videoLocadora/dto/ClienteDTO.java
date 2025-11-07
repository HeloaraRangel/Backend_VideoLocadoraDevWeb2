package com.example.videoLocadora.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.entity.ClienteEntity;
public class ClienteDTO {

	private Long id;
	private int numInscricao;	
	private String nome;
	private Date dtNascimento; 
	private String sexo;
	private String estaAtivo;	
	
	//para converter de entity para dto 
	public ClienteDTO(ClienteEntity cliente) {
		BeanUtils.copyProperties(cliente, this);
	}
	
	//construtor
	public ClienteDTO() {
				
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumInscricao() {
		return numInscricao;
	}

	public void setNumInscricao(int numInscricao) {
		this.numInscricao = numInscricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstaAtivo() {
		return estaAtivo;
	}

	public void setEstaAtivo(String estaAtivo) {
		this.estaAtivo = estaAtivo;
	}
	
	
	
}
