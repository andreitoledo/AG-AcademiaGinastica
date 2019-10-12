package com.andreitoledo.ac.controller.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.ac.dao.SalaDAO;
import com.andreitoledo.ac.model.Sala;
import com.andreitoledo.ac.service.CadastroSalaService;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaSalaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	SalaDAO salaDAO;

	@Inject
	CadastroSalaService cadastroSalaService;

	private List<Sala> salas = new ArrayList<>();

	private Sala salaSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<Sala> getSalas() {
		return salas;
	}

	@PostConstruct
	public void inicializar() {
		salas = salaDAO.buscarTodos();

	}

	public void excluir() {

		try {
			cadastroSalaService.excluir(salaSelecionado);
			this.salas.remove(salaSelecionado);
			facesMessages.info("Sala " + salaSelecionado.getDescricao() + " excluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}

	}

	public Sala getSalaSelecionado() {
		return salaSelecionado;
	}

	public void setSalaSelecionado(Sala salaSelecionado) {
		this.salaSelecionado = salaSelecionado;
	}

}
