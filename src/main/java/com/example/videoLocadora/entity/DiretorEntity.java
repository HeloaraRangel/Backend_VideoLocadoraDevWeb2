package com.example.videoLocadora.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.dto.DiretorDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Diretor")
public class DiretorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable = false)
	private String nome;
	
	//para converter de dto para entity
	public DiretorEntity(DiretorDTO diretor) {
		BeanUtils.copyProperties(diretor, this);
	}
		
	//construtor
	public DiretorEntity() {
		
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
		DiretorEntity other = (DiretorEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
