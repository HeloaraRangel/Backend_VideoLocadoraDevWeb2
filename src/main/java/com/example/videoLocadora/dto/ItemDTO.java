package com.example.videoLocadora.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.entity.ItemEntity;

public class ItemDTO {

    private Long id;
    private String numSerie;
    private Date dtAquisicao;
    private String tipoItem;
    private TituloDTO titulo;

    public ItemDTO() {
    }

    public ItemDTO(ItemEntity item) {
        BeanUtils.copyProperties(item, this);

        if (item.getTitulo() != null) {
            this.titulo = new TituloDTO(item.getTitulo());
        }
    }

	// getters e setters
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

	public TituloDTO getTitulo() {
		return titulo;
	}

	public void setTitulo(TituloDTO titulo) {
		this.titulo = titulo;
	}

    
    
}

