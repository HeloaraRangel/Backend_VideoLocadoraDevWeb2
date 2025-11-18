package com.example.videoLocadora.entity;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.dto.TituloDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "Titulo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TituloEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable = false)
	private String nome;
	
	@Column (nullable = false) 
	private int ano;
	
	@Column (nullable = false)
	private String sinopse;
	
	@Column (nullable = false)
	private String categoria;
	
	@ManyToMany
	@JoinTable(name = "titulo_ator",
	    joinColumns = @JoinColumn(name = "titulo_id"),
	    inverseJoinColumns = @JoinColumn(name = "ator_id"))
	private List<AtorEntity> atores;
	
	@ManyToOne
	@JoinColumn(name = "diretor_id")
	private DiretorEntity diretor;
	
	
	@ManyToOne
	@JoinColumn(name = "classe_id")
	private ClasseEntity classe;
	
	
	
	//construtor
	public TituloEntity() {
			
	}
	
	//para converter de dto para entity
	public TituloEntity(TituloDTO titulo) {
		BeanUtils.copyProperties(titulo, this);
	}

	//Gets e sets
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
	
	
	public List<AtorEntity> getAtores() {
		return atores;
	}

	public void setAtores(List<AtorEntity> atores) {
		this.atores = atores;
	}

	public DiretorEntity getDiretor() {
		return diretor;
	}

	public void setDiretor(DiretorEntity diretor) {
		this.diretor = diretor;
	}


	public ClasseEntity getClasse() {
		return classe;
	}

	public void setClasse(ClasseEntity classe) {
		this.classe = classe;
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
		TituloEntity other = (TituloEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
