package com.example.videoLocadora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Socio")
public class SocioEntity extends ClienteEntity{
	
	@Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String tel;

    public SocioEntity(){
    	
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
    
    
}
