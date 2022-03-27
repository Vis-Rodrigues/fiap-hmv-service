package com.fiap.hmv.entity.usuario;

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

import com.fiap.hmv.model.dto.usuario.NovoUsuarioDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2419826215351504496L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nome", nullable=false, length=60)
	private String nome;
	
	@Column(name="email", nullable=false, length=255)
	private String email;
	
	@Column(name="doc_tipo", nullable=false)
	private String docTipo;
	
	@Column(name="doc_numero", nullable=false, length=20)
	private String docNumero;
	
	@Column(name="ativo", nullable=false)
	private boolean ativo;
	
	@Column(name="foto", nullable=false, length=300)
	private String foto;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="email_verified_at")
	protected Calendar dtEmailVerificado;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	protected Calendar dtCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	protected Calendar dtAtualizacao;
	
	@Column(name="password", length=255)
	private String senha;
	
	@Column(name="remember_token", length=255)
	private String token;
	
	@Column(name="two_factor_secret")
	private String twoFactorSecret;
	
	@Column(name="two_factor_recovery_codes")
	private String twoFactorRecoveryCodes;
	
	public Usuario (NovoUsuarioDTO novo){
		this.nome = novo.getNome();
		this.email = novo.getEmail();
		this.docTipo = novo.getDocTipo().getDescricao();
		this.docNumero = novo.getDocNumero();
		this.foto = novo.getFoto();
		this.ativo = true;
		this.senha = novo.getSenha();
	}
	
}
