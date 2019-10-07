package com.andreitoledo.ac.controller.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.ac.dao.InstrutorDAO;
import com.andreitoledo.ac.model.Instrutor;
import com.andreitoledo.ac.service.CadastroInstrutorService;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaInstrutorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	InstrutorDAO instrutorDAO;

	@Inject
	CadastroInstrutorService cadastroInstrutorService;

	private List<Instrutor> instrutores = new ArrayList<>();

	private Instrutor instrutorSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}

	@PostConstruct
	public void inicializar() {
		instrutores = instrutorDAO.buscarTodos();
	}

	public void excluir() {
		try {
			cadastroInstrutorService.excluir(instrutorSelecionado);
			this.instrutores.remove(instrutorSelecionado);
			facesMessages.info("Instrutor " + instrutorSelecionado.getNome() + " excluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Instrutor getInstrutorSelecionado() {
		return instrutorSelecionado;
	}

	public void setInstrutorSelecionado(Instrutor instrutorSelecionado) {
		this.instrutorSelecionado = instrutorSelecionado;
	}

}
