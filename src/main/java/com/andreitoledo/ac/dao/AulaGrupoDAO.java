package com.andreitoledo.ac.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.ac.model.AulaGrupo;
import com.andreitoledo.ac.service.NegocioException;

public class AulaGrupoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public AulaGrupo buscarPeloCodigo(Long codigo) {
		return manager.find(AulaGrupo.class, codigo);

	}

	@SuppressWarnings("unchecked")
	public List<AulaGrupo> buscarTodos() {
		return manager.createQuery("Select ag  from AulaGrupo ag ").getResultList();

	}

	public void salvar(AulaGrupo aulaGrupo) {
		manager.merge(aulaGrupo);

	}

	public void excluir(AulaGrupo aulaGrupo) throws NegocioException {
		aulaGrupo = buscarPeloCodigo(aulaGrupo.getCodigo());

		try {
			manager.remove(aulaGrupo);
			manager.flush();

		} catch (PersistenceException e) {

			throw new NegocioException("Aula em grupo " + aulaGrupo.getDescricao() + " não pode ser excluído.");

		}

	}

}
