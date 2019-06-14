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

import com.andreitoledo.ac.model.Usuario;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Usuario buscarPeloCodigo(Long codigo) {
		return manager.find(Usuario.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		return manager.createQuery("Select u from Usuario u").getResultList();
	}

	public void salvar(Usuario usuario) {
		manager.merge(usuario);
	}

	@Transactional
	public void excluir(Usuario usuario) throws NegocioException {
		usuario = buscarPeloCodigo(usuario.getCodigo());

		try {
			manager.remove(usuario);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Usuário não pode ser excluído.");

		}

	}

}
