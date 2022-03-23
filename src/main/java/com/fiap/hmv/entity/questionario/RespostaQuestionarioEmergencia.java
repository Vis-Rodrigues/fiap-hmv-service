package com.fiap.hmv.entity.questionario;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_respostas_perguntas_emergencia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespostaQuestionarioEmergencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9007294966976281599L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_at")
	protected Calendar dtCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_at")
	protected Calendar dtAtualizacao;
	
	@Column(name="resposta", nullable=false)
	private String resposta;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="questionario_emergencia_id", referencedColumnName="id")
	private QuestionarioEmergencia questionarioEmergencia;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pergunta_emergencia_id", referencedColumnName="id")
	private PerguntaQuestionarioEmergencia perguntaQuestionarioEmergencia;
	
}
