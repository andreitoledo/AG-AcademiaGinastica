/**
 * @author andrei
 *
 * 13 de jan de 2019
 */
package com.andreitoledo.ac.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.ac.dao.GrupoDAO;
import com.andreitoledo.ac.model.Grupo;
import com.andreitoledo.ac.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class CadastroGrupoService implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GrupoDAO grupoDAO;
	
	@Transactional
	public void salvar(Grupo grupo) throws NegocioException{
		
		this.grupoDAO.salvar(grupo);
		
	}

}
