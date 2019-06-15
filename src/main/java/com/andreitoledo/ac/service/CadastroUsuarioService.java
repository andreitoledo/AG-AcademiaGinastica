/**
 * @author andrei
 *
 * 13 de jan de 2019
 */
package com.andreitoledo.ac.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.ac.dao.UsuarioDAO;
import com.andreitoledo.ac.model.Usuario;
import com.andreitoledo.ac.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Transactional
	public void salvar(Usuario usuario) throws NegocioException {
		
		/*regra: nome precisa ser informado*/
		if (usuario.getNome() == null 
			|| usuario.getNome().equals("")){
		throw new NegocioException("O Nome deve ser informado.");
		
		}

		this.usuarioDAO.salvar(usuario);
	}

}
