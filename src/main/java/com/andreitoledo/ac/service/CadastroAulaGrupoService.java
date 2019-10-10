package com.andreitoledo.ac.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.ac.dao.AulaGrupoDAO;
import com.andreitoledo.ac.model.AulaGrupo;
import com.andreitoledo.ac.util.jpa.Transactional;

public class CadastroAulaGrupoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AulaGrupoDAO aulaGrupoDAO;

	@Transactional
	public void salvar(AulaGrupo aulaGrupo) throws NegocioException {

		this.aulaGrupoDAO.salvar(aulaGrupo);

	}

	@Transactional
	public void excluir(AulaGrupo aulaGrupo) throws NegocioException {

		this.aulaGrupoDAO.excluir(aulaGrupo);

	}

}
