package com.andreitoledo.ac.controller.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.ac.model.TipoAtividade;
import com.andreitoledo.ac.service.CadastroTipoAtividadeService;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroTipoAtividadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TipoAtividade tipoAtividade;

	@Inject
	private CadastroTipoAtividadeService cadastroTipoAtividadeService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (tipoAtividade == null) {
			limpar();

		}
	}

	private void limpar() {
		this.tipoAtividade = new TipoAtividade();

	}

	public void salvar() {
		try {
			this.cadastroTipoAtividadeService.salvar(tipoAtividade);
			facesMessages.info("Tipo Atividade " + tipoAtividade.getDescricao() + " salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public boolean isEditando() {
		return this.tipoAtividade.getCodigo() != null;
	}

}
