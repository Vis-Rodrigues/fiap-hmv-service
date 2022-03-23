package com.fiap.hmv.entity.usuario;

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

import org.hibernate.annotations.CreationTimestamp;

import com.fiap.hmv.entity.endereco.Endereco;
import com.fiap.hmv.entity.estabelecimento.Estabelecimento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="associativa_enderecos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEndereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	protected Calendar dtCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	protected Calendar dtAtualizacao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuario_id", referencedColumnName="id")
	private Usuario usuario;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="estabelecimento_id", referencedColumnName="id")
	private Estabelecimento estabelecimento;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="endereco_id", referencedColumnName="id")
	private Endereco endereco;
	
	public UsuarioEndereco(Usuario usuario, Endereco endereco) {
		this.usuario = usuario;
		this.endereco = endereco;
	}
	
	public UsuarioEndereco(Estabelecimento estabelecimento, Endereco endereco) {
		this.estabelecimento = estabelecimento;
		this.endereco = endereco;
	}
}
