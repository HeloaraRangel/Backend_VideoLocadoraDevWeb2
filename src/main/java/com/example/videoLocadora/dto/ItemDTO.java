package com.example.videoLocadora.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.entity.ItemEntity;

public class ItemDTO {
	
	private Long id;
	private String numSerie;
	private Date dtAquisicao;
	private String tipoItem;
	
	public ItemDTO(ItemEntity item) {
		BeanUtils.copyProperties(item, this);
	}
	
	//construtor
	public ItemDTO() {
					
	}

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
