package com.example.videoLocadora.entity;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.dto.ClasseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Classe")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClasseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable = false)
	private String nome;
	
	@Column (nullable = false)
	private double valor;
	
	@Column (nullable = false)
	private int prazoDevolucao;
	
	@OneToMany(mappedBy="classe")
	private List<TituloEntity> titulos;
	
	//para converter de dto para entity
	public ClasseEntity(ClasseDTO classe) {
		BeanUtils.copyProperties(classe, this);
	}
	
	//construtor
	public ClasseEntity() {
		
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
		ClasseEntity other = (ClasseEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
