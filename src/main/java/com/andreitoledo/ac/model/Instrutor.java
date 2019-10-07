package com.andreitoledo.ac.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instrutor")

@DiscriminatorValue("INSTRUTOR")

public class Instrutor extends Entidade {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "codigo_tipo_atividade")
	private TipoAtividade tipoAtividade;

	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

}
