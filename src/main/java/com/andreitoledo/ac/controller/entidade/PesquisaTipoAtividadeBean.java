package com.andreitoledo.ac.controller.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.ac.dao.TipoAtividadeDAO;
import com.andreitoledo.ac.model.TipoAtividade;
import com.andreitoledo.ac.service.CadastroTipoAtividadeService;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaTipoAtividadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	TipoAtividadeDAO tipoAtividadeDAO;

	@Inject
	CadastroTipoAtividadeService cadastroTipoAtividadeService;

	private List<TipoAtividade> tipoAtividades = new ArrayList<>();

	private TipoAtividade tipoAtividadeSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<TipoAtividade> getTipoAtividades() {
		return tipoAtividades;
	}

	@PostConstruct
	public void inicializar() {
		tipoAtividades = tipoAtividadeDAO.buscarTodos();
	}

	public void excluir() {
		try {
			cadastroTipoAtividadeService.excluir(tipoAtividadeSelecionado);
			this.tipoAtividades.remove(tipoAtividadeSelecionado);
			facesMessages.info("Tipo Atividade " + tipoAtividadeSelecionado.getDescricao() + " excluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public TipoAtividade getTipoAtividadeSelecionado() {
		return tipoAtividadeSelecionado;
	}

	public void setTipoAtividadeSelecionado(TipoAtividade tipoAtividadeSelecionado) {
		this.tipoAtividadeSelecionado = tipoAtividadeSelecionado;
	}

}
