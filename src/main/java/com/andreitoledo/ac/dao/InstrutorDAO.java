package com.andreitoledo.ac.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.ac.model.Instrutor;
import com.andreitoledo.ac.service.NegocioException;

public class InstrutorDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Instrutor buscarPeloCodigo(Long codigo) {
		return manager.find(Instrutor.class, codigo);

	}

	@SuppressWarnings("unchecked")
	public List<Instrutor> buscarTodos() {
		return manager.createQuery("Select i from Instrutor i").getResultList();

	}

	public void salvar(Instrutor instrutor) {
		manager.merge(instrutor);

	}

	public void excluir(Instrutor instrutor) throws NegocioException {
		instrutor = buscarPeloCodigo(instrutor.getCodigo());

		try {
			manager.remove(instrutor);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("O instrutor " + instrutor.getNome() + " não pode ser excluído.");

		}

	}

}
