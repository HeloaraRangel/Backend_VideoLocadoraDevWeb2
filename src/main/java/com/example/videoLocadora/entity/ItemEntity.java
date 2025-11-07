package com.example.videoLocadora.entity;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.dto.ItemDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Item")
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable = false)
	private String numSerie;
	
	@Column (nullable = false) 
	private Date dtAquisicao;
	
	@Column (nullable = false)
	private String tipoItem;
	
	//para converter de dto para entity
	public ItemEntity(ItemDTO item) {
		BeanUtils.copyProperties(item, this);
	}
		
	//construtor
	public ItemEntity() {
			
	}

	//Gets e sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public Date getDtAquisicao() {
		return dtAquisicao;
	}

	public void setDtAquisicao(Date dtAquisicao) {
		this.dtAquisicao = dtAquisicao;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}
	
	
	
	
	
}
