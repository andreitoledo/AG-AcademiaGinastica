package com.andreitoledo.ac.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.ac.model.Sala;
import com.andreitoledo.ac.service.NegocioException;

public class SalaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Sala buscarPeloCodigo(Long codigo) {
		return manager.find(Sala.class, codigo);

	}

	@SuppressWarnings("unchecked")
	public List<Sala> buscarTodos() {
		return manager.createQuery("Select s from Sala s ").getResultList();

	}

	public void salvar(Sala sala) {
		manager.merge(sala);

	}

	public void excluir(Sala sala) throws NegocioException {

		sala = buscarPeloCodigo(sala.getCodigo());

		try {
			manager.remove(sala);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Sala " + sala.getDescricao() + "não pode ser excluído.");

		}

	}

}
