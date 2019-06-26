package com.andreitoledo.ac.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")

/* conceito de herança poo */
@DiscriminatorValue("CLIENTE")

/* herdando atributos da classe Entidade */
public class Cliente extends Entidade {

	private static final long serialVersionUID = 1L;

	private String endereco;

	/* geters and seters */
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
