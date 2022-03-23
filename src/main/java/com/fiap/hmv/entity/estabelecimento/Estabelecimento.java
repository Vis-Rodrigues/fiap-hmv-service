package com.fiap.hmv.entity.estabelecimento;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_estabelecimentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estabelecimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1450364532668922373L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nome", nullable=false, length=60)
	private String nome;
	
	@Column(name="email", nullable=false, length=60)
	private String email;
	
	@Column(name="telefone", length=15)
	private String telefone;
	
	@Column(name="cnpj", nullable=false, length=20)
	private String cnpj;
	
	@Column(name="imagem", length=300)
	private String logo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data")
	protected Calendar dtAgendamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo", nullable=false, length=255)
	private ETipoEstabelecimento tipoEstabelecimento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_at")
	protected Calendar dtCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_at")
	protected Calendar dtAtualizacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="delete_at")
	protected Calendar dtExclusao;
	
}
