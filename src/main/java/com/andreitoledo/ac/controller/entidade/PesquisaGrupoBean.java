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

import com.andreitoledo.ac.dao.GrupoDAO;
import com.andreitoledo.ac.model.Grupo;
import com.andreitoledo.ac.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class PesquisaGrupoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	GrupoDAO grupoDAO;

	private List<Grupo> grupos = new ArrayList<>();

	private Grupo grupoSelecionado;

	@Inject
	private FacesMessages facesMessages;

	/**
	 * @return the grupos
	 */
	public List<Grupo> getGrupos() {
		return grupos;
	}

	@PostConstruct
	public void inicializar() {
		grupos = grupoDAO.buscarTodos();

	}

	public void excluir() {
		try {
			grupoDAO.excluir(grupoSelecionado);
			this.grupos.remove(grupoSelecionado);

		} catch (Exception e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Grupo getGrupoSelecionado() {
		return grupoSelecionado;
	}

	public void setGrupoSelecionado(Grupo grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}

}
