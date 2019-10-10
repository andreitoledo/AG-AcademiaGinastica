package com.andreitoledo.ac.controller.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.ac.dao.AulaGrupoDAO;
import com.andreitoledo.ac.model.AulaGrupo;
import com.andreitoledo.ac.service.CadastroAulaGrupoService;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaAulaGrupoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AulaGrupoDAO aulaGrupoDAO;

	@Inject
	CadastroAulaGrupoService cadastroAulaGrupoService;

	private List<AulaGrupo> aulaGrupos = new ArrayList<>();

	private AulaGrupo aulaGrupoSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<AulaGrupo> getAulaGrupos() {
		return aulaGrupos;
	}

	@PostConstruct
	public void inicializar() {
		aulaGrupos = aulaGrupoDAO.buscarTodos();
	}

	public void excluir() {
		try {
			cadastroAulaGrupoService.excluir(aulaGrupoSelecionado);
			this.aulaGrupos.remove(aulaGrupoSelecionado);
			facesMessages.info("Aula grupo " + aulaGrupoSelecionado.getDescricao() + " excluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public AulaGrupo getAulaGrupoSelecionado() {
		return aulaGrupoSelecionado;
	}

	public void setAulaGrupoSelecionado(AulaGrupo aulaGrupoSelecionado) {
		this.aulaGrupoSelecionado = aulaGrupoSelecionado;
	}

}
