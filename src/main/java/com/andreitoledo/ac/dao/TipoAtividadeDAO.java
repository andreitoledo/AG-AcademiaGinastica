package com.andreitoledo.ac.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.ac.model.TipoAtividade;
import com.andreitoledo.ac.service.NegocioException;

public class TipoAtividadeDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public TipoAtividade buscarPeloCodigo(Long codigo) {
		return manager.find(TipoAtividade.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<TipoAtividade> buscarTodos() {
		return manager.createQuery("select ta from TipoAtividade ta ").getResultList();
	}

	public void salvar(TipoAtividade tipoAtividade) {
		manager.merge(tipoAtividade);

	}

	public void excluir(TipoAtividade tipoAtividade) throws NegocioException {
		tipoAtividade = buscarPeloCodigo(tipoAtividade.getCodigo());

		try {
			manager.remove(tipoAtividade);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Tipo Atividade " + tipoAtividade.getDescricao() + " não pode ser excluído.");
		}
	}

}
