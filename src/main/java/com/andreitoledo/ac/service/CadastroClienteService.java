package com.andreitoledo.ac.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.ac.dao.ClienteDAO;
import com.andreitoledo.ac.model.Cliente;
import com.andreitoledo.ac.util.jpa.Transactional;

public class CadastroClienteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteDAO clienteDAO;

	@Transactional
	public void salvar(Cliente cliente) throws NegocioException {

		this.clienteDAO.salvar(cliente);

	}

	@Transactional
	public void excluir(Cliente cliente) throws NegocioException {

		this.clienteDAO.excluir(cliente);

	}

}
