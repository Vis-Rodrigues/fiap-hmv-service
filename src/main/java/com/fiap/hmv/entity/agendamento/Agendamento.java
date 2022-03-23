package com.fiap.hmv.entity.agendamento;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fiap.hmv.entity.estabelecimento.Estabelecimento;
import com.fiap.hmv.entity.perfil.Perfil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="agendamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 2570925826833288037L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data")
	protected Calendar dtAgendamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="situacao", nullable=false, length=255)
	private ESituacaoAgendamento situacaoAgendamento;
	
	@Column(name="observacoes", length=300)
	private String observacao;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	protected Calendar dtCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	protected Calendar dtAtualizacao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="medico_perfil_id", referencedColumnName="id")
	private Perfil medicoPerfil;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="paciente_perfil_id", referencedColumnName="id")
	private Perfil pacientePerfil;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="estabelecimento_id", referencedColumnName="id")
	private Estabelecimento estabelecimento;
}
