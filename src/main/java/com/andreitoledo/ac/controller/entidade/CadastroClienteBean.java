package com.andreitoledo.ac.controller.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.ac.model.Cliente;
import com.andreitoledo.ac.service.CadastroClienteService;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;

	@Inject
	private CadastroClienteService cadastroClienteService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (cliente == null) {
			limpar();

		}

	}

	private void limpar() {
		this.cliente = new Cliente();

	}

	public void salvar() {
		try {
			this.cadastroClienteService.salvar(cliente);
			facesMessages.info("Cliente " + cliente.getNome() + " salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isEditando() {
		return this.cliente.getCodigo() != null;
	}

}
