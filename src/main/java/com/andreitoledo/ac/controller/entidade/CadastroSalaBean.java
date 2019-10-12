package com.andreitoledo.ac.controller.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.ac.model.Sala;
import com.andreitoledo.ac.service.CadastroSalaService;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroSalaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Sala sala;

	@Inject
	private CadastroSalaService cadastroSalaService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (sala == null) {
			limpar();

		}
	}

	private void limpar() {
		this.sala = new Sala();

	}

	public void salvar() {
		try {
			this.cadastroSalaService.salvar(sala);
			facesMessages.info("Sala " + sala.getDescricao() + " salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public boolean isEditando() {
		return this.sala.getCodigo() != null;
	}

}
