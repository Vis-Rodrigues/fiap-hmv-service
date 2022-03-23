package com.fiap.hmv.entity.agendamento;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fiap.hmv.entity.perfil.Perfil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="historicos_atendimento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoAtendimento implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 3102039909238041574L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="relatorio", length=1000)
	private String relatorio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data", nullable=false)
	protected Calendar dtAgendamento;
	
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
	
//	@OneToOne(cascade=CascadeType.ALL, mappedBy="id")
//	@JoinColumn(name="agendamento_id")
//	private Agendamento agendamento;

}
