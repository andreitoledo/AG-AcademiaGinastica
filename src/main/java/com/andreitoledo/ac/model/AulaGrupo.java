package com.andreitoledo.ac.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/***
 * 
 * @author Andrei
 * 
 *         O sistema deve permitir o cadastro de aulas em grupo. Para cada aula
 *         em grupo, devem ser informados: o nome da aula, o horário de início e
 *         fim, o nome do instrutor alocado, os dias de semana em que a aula
 *         ocorre e a sala onde a aula acontece. Tal funcionalidade é realizada
 *         pelo Recepcionista. As salas não precisam ser cadastradas pelo
 *         sistema.
 *
 */

@Entity
@Table(name = "aula_grupo")
public class AulaGrupo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String descricao;

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_inicio")
	private Date horaInicio;

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_fim")
	private Date horaFim;

	@ManyToOne
	@JoinColumn(name = "codigo_instrutor")
	private Instrutor InstrutorAlocado;

	@Temporal(TemporalType.DATE)
	@Column(name = "dias_semana")
	private Date diasSemana;

	@ManyToOne
	@JoinColumn(name = "codigo_sala")
	private Sala sala;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public Instrutor getInstrutorAlocado() {
		return InstrutorAlocado;
	}

	public void setInstrutorAlocado(Instrutor instrutorAlocado) {
		InstrutorAlocado = instrutorAlocado;
	}

	public Date getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(Date diasSemana) {
		this.diasSemana = diasSemana;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AulaGrupo other = (AulaGrupo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
