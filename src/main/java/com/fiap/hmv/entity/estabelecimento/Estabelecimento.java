package com.fiap.hmv.entity.estabelecimento;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fiap.hmv.model.dto.estabelecimento.NovoEstabelecimentoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="estabelecimentos")
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
	
	@Column(name="site", length=300)
	private String site;
	
	@Column(name="tipo", nullable=false, length=255)
	private String tipoEstabelecimento;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	protected Calendar dtCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	protected Calendar dtAtualizacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="deleted_at")
	protected Calendar dtExclusao;
	
	public Estabelecimento(NovoEstabelecimentoDTO novo) {
		this.email = novo.getEmail();
		this.logo = novo.getLogo();
		this.cnpj = novo.getCnpj();
		this.nome = novo.getNome();
		this.site = novo.getSite();
		this.telefone = novo.getTelefone();
		this.tipoEstabelecimento = novo.getTipo().getDescricao();
	}
	
}
