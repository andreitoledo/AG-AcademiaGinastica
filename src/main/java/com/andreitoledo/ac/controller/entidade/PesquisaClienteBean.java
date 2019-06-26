package com.andreitoledo.ac.controller.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.ac.dao.ClienteDAO;
import com.andreitoledo.ac.model.Cliente;
import com.andreitoledo.ac.service.CadastroClienteService;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ClienteDAO clienteDAO;

	@Inject
	CadastroClienteService cadastroClienteService;

	private List<Cliente> clientes = new ArrayList<>();

	private Cliente clienteSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<Cliente> getClientes() {
		return clientes;
	}

	@PostConstruct
	public void inicializar() {
		clientes = clienteDAO.buscarTodos();
	}

	public void excluir() {
		try {
			cadastroClienteService.excluir(clienteSelecionado);
			this.clientes.remove(clienteSelecionado);
			facesMessages.info("Cliente " + clienteSelecionado.getNome() + " exluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

}
