/**
 * @author andrei
 *
 * 5 de dez de 2018
 */
package com.andreitoledo.ac.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.andreitoledo.ac.model.Usuario;

/**
 * @author andrei
 *
 */
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Usuario porCodigo(Long codigo) {
		return this.manager.find(Usuario.class, codigo);

	}

	public List<Usuario> pacientes() {
		// TODO filtrar apenas pacientes (por um grupo especifico)
		return this.manager.createQuery("from Usuario", Usuario.class).getResultList();
	}

	public Usuario porEmail(String email) {
		Usuario usuario = null;

		try {
			usuario = this.manager.createQuery("from Usuario where lower(email) = :email", Usuario.class)
					.setParameter("email", email.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			// nenhum usuário encontrado com o e-mail informado
		}

		return usuario;
	}

}
