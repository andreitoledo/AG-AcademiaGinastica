package com.andreitoledo.ac.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.ac.dao.InstrutorDAO;
import com.andreitoledo.ac.model.Instrutor;
import com.andreitoledo.ac.util.jpa.Transactional;

public class CadastroInstrutorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private InstrutorDAO instrutorDAO;

	@Transactional
	public void salvar(Instrutor instrutor) throws NegocioException {

		this.instrutorDAO.salvar(instrutor);
	}

	@Transactional
	public void excluir(Instrutor instrutor) throws NegocioException {

		this.instrutorDAO.excluir(instrutor);

	}

}
