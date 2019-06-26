package com.andreitoledo.ac.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.ac.model.Cliente;
import com.andreitoledo.ac.service.NegocioException;

public class ClienteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	/* método buscar pelo código */
	public Cliente buscarPeloCodigo(Long codigo) {
		return manager.find(Cliente.class, codigo);

	}

	/* método buscar todos os clientes */
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		return manager.createQuery("Select c from Cliente c").getResultList();

	}

	/* método salvar */
	public void salvar(Cliente cliente) {
		manager.merge(cliente);
	}

	/* método excluir */
	public void excluir(Cliente cliente) throws NegocioException {
		cliente = buscarPeloCodigo(cliente.getCodigo());

		try {
			manager.remove(cliente);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("O cliente " + cliente.getNome() + " não pode ser excluído.");

		}

	}

}
