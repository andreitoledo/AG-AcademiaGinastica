package com.andreitoledo.ac.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.ac.dao.SalaDAO;
import com.andreitoledo.ac.model.Sala;
import com.andreitoledo.ac.util.jpa.Transactional;

public class CadastroSalaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SalaDAO salaDAO;

	@Transactional
	public void salvar(Sala sala) throws NegocioException {

		this.salaDAO.salvar(sala);

	}

	@Transactional
	public void excluir(Sala sala) throws NegocioException {

		this.salaDAO.excluir(sala);

	}

}
