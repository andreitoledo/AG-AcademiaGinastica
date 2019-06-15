/**
 * @author andrei
 *
 * 19 de jan de 2019
 */
package com.andreitoledo.ac.controller.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.ac.dao.UsuarioDAO;
import com.andreitoledo.ac.model.Usuario;
import com.andreitoledo.ac.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	UsuarioDAO usuarioDAO;

	private List<Usuario> usuarios = new ArrayList<>();

	private Usuario usuarioSelecionado;

	@Inject
	private FacesMessages facesMessages;

	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	@PostConstruct
	public void inicializar() {
		usuarios = usuarioDAO.buscarTodos();

	}

	public void excluir() {
		try {
			usuarioDAO.excluir(usuarioSelecionado);
			this.usuarios.remove(usuarioSelecionado);

		} catch (Exception e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

}
