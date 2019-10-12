package com.andreitoledo.ac.controller.entidade;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.ac.dao.InstrutorDAO;
import com.andreitoledo.ac.dao.SalaDAO;
import com.andreitoledo.ac.model.AulaGrupo;
import com.andreitoledo.ac.model.Instrutor;
import com.andreitoledo.ac.model.Sala;
import com.andreitoledo.ac.service.CadastroAulaGrupoService;
import com.andreitoledo.ac.service.NegocioException;
import com.andreitoledo.ac.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroAulaGrupoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private AulaGrupo aulaGrupo;

	@Inject
	private CadastroAulaGrupoService cadastroAulaGrupoService;

	private List<Instrutor> instrutores;

	private List<Sala> salas;

	@Inject
	private InstrutorDAO instrutorDAO;

	@Inject
	private SalaDAO salaDAO;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (aulaGrupo == null) {
			limpar();

		}

		this.instrutores = this.instrutorDAO.buscarTodos();
		this.salas = this.salaDAO.buscarTodos();
	}

	private void limpar() {
		this.aulaGrupo = new AulaGrupo();

	}

	public void salvar() {
		try {
			this.cadastroAulaGrupoService.salvar(aulaGrupo);
			facesMessages.info("Aula grupo " + aulaGrupo.getDescricao() + " salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public AulaGrupo getAulaGrupo() {
		return aulaGrupo;
	}

	public void setAulaGrupo(AulaGrupo aulaGrupo) {
		this.aulaGrupo = aulaGrupo;
	}

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public boolean isEditando() {
		return this.aulaGrupo.getCodigo() != null;
	}

}
