/**
 * @author andrei
 *
 * 13 de jan de 2019
 */
package com.andreitoledo.ac.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.ac.model.Grupo;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class GrupoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Grupo buscarPeloCodigo(Long codigo) {
		return manager.find(Grupo.class, codigo);

	}

	@SuppressWarnings("unchecked")
	public List<Grupo> buscarTodos() {
		return manager.createQuery("Select g from Grupo g").getResultList();

	}

	public void salvar(Grupo grupo) {
		manager.merge(grupo);

	}

	@Transactional
	public void excluir(Grupo grupo) throws NegocioException {
		grupo = buscarPeloCodigo(grupo.getCodigo());

		try {
			manager.remove(grupo);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Esse grupo não pode ser excluído.");

		}

	}

}
