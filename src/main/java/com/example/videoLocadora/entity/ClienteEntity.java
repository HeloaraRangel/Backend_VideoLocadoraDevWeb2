package com.example.videoLocadora.entity;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.dto.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable = false)
	private int numInscricao;
	
	@Column (nullable = false)
	private String nome;
	
	@Column (nullable = false) 
	private Date dtNascimento; 
	
	@Column (nullable = false) 
	private String sexo;
	
	@Column (nullable = false)
	private String estaAtivo;
	
	//construtor
	public ClienteEntity() {
		
	}
	
	//para converter de dto para entity
	public ClienteEntity(ClienteDTO cliente) {
		BeanUtils.copyProperties(cliente, this);
	}
	
	//Gets e sets
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
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteEntity other = (ClienteEntity) obj;
		return Objects.equals(id, other.id);
	}
		
}
