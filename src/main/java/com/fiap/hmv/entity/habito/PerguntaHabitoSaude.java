package com.fiap.hmv.entity.habito;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fiap.hmv.entity.enums.ETipoPergunta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_perguntas_habitos_saude")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerguntaHabitoSaude implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7805910523061846124L;

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="pergunta", nullable=false, length=300)
	private String pergunta;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo", nullable=false, length=255)
	private ETipoPergunta tipoPergunta;
	
	@Column(name="opcoes", nullable=false)
	private String opcoes;
	
	@Column(name="prioridade", nullable=false)
	private Integer prioridade;
	
	@Column(name="obrigatoria", nullable=false)
	private boolean obrigatoria;
	
	@Column(name="ativo", nullable=false)
	private boolean ativo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_at")
	protected Calendar dtCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_at")
	protected Calendar dtAtualizacao;
}
