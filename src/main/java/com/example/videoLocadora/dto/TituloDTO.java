package com.example.videoLocadora.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.example.videoLocadora.entity.TituloEntity;

public class TituloDTO {

    private Long id;
    private String nome;
    private int ano;
    private String sinopse;
    private String categoria;
    private List<AtorDTO> atores;
    private ClasseDTO classe;
    private DiretorDTO diretor;

    public TituloDTO(TituloEntity titulo) {
        BeanUtils.copyProperties(titulo, this);

        // CLASSE
        if (titulo.getClasse() != null) {
            this.classe = new ClasseDTO(titulo.getClasse());
        }

        // DIRETOR
        if (titulo.getDiretor() != null) {
            this.diretor = new DiretorDTO(titulo.getDiretor());
        }

        // ATORES 
        if (titulo.getAtores() != null) {
            this.atores = titulo.getAtores()
                    .stream()
                    .map(AtorDTO::new)
                    .toList();
        }
    }

    public TituloDTO() {}

	// getters e setters
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

	public List<AtorDTO> getAtores() {
		return atores;
	}

	public void setAtores(List<AtorDTO> atores) {
		this.atores = atores;
	}

	public ClasseDTO getClasse() {
		return classe;
	}

	public void setClasse(ClasseDTO classe) {
		this.classe = classe;
	}

	public DiretorDTO getDiretor() {
		return diretor;
	}

	public void setDiretor(DiretorDTO diretor) {
		this.diretor = diretor;
	}

    
    
}


