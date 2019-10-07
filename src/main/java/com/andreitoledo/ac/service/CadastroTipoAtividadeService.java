package com.andreitoledo.ac.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.ac.dao.TipoAtividadeDAO;
import com.andreitoledo.ac.model.TipoAtividade;
import com.andreitoledo.ac.util.jpa.Transactional;

public class CadastroTipoAtividadeService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoAtividadeDAO tipoAtividadeDAO;

	@Transactional
	public void salvar(TipoAtividade tipoAtividade) throws NegocioException {

		this.tipoAtividadeDAO.salvar(tipoAtividade);
	}

	@Transactional
	public void excluir(TipoAtividade tipoAtividade) throws NegocioException {

		this.tipoAtividadeDAO.excluir(tipoAtividade);
	}

}
