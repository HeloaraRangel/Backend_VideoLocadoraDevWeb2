package com.example.videoLocadora.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Dependente")
public class DependenteEntity extends ClienteEntity {
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "socio_id")
    private SocioEntity socio;

    public DependenteEntity(){
    	
    }

	public SocioEntity getSocio() {
		return socio;
	}

	public void setSocio(SocioEntity socio) {
		this.socio = socio;
	}
    
    
}
