package com.andreitoledo.ac.controller.entidade;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.ac.dao.TipoAtividadeDAO;
import com.andreitoledo.ac.model.Instrutor;
import com.andreitoledo.ac.model.TipoAtividade;
import com.andreitoledo.ac.service.CadastroInstrutorService;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroInstrutorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Instrutor instrutor;

	@Inject
	private CadastroInstrutorService cadastroInstrutorService;

	private List<TipoAtividade> tipoAtividades;

	@Inject
	private TipoAtividadeDAO tipoAtividadeDAO;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (instrutor == null) {
			limpar();

		}

		this.tipoAtividades = this.tipoAtividadeDAO.buscarTodos();
	}

	private void limpar() {
		this.instrutor = new Instrutor();

	}

	public void salvar() {
		try {
			this.cadastroInstrutorService.salvar(instrutor);
			facesMessages.info("Instrutor " + " salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public List<TipoAtividade> getTipoAtividades() {
		return tipoAtividades;
	}

	public boolean isEditando() {
		return this.instrutor.getCodigo() != null;
	}

}
