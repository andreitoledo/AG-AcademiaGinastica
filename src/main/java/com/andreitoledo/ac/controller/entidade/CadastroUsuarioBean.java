/**
 * @author andrei
 *
 * 19 de jan de 2019
 */
package com.andreitoledo.ac.controller.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.ac.model.Usuario;
import com.andreitoledo.ac.service.CadastroUsuarioService;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	@Inject
	private CadastroUsuarioService cadastroUsuarioService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (usuario == null) {
			limpar();

		}

	}

	/**
	 * 
	 */
	private void limpar() {
		this.usuario = new Usuario();

	}

	public void salvar() {
		try {
			this.cadastroUsuarioService.salvar(usuario);
			facesMessages.info("Usuário salvo com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}

		limpar();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isEditando() {
		return this.usuario.getCodigo() != null;
	}

}
