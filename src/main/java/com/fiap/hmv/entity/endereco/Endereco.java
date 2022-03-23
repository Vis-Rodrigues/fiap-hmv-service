package com.fiap.hmv.entity.endereco;

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

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.fiap.hmv.model.dto.endereco.EnderecoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="enderecos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8525361417705443610L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nome", length=60)
	private String nome;
	
	@Column(name="logradouro", nullable=false, length=40)
	private String logradouro;
	
	@Column(name="tipo", nullable=false, length=20)
	private String tipo;
	
	@Column(name="cep", nullable=false, length=9)
	private String cep;
	
	@Column(name="numero", nullable=false, length=10)
	private String numero;
	
	@Column(name="cidade", nullable=false, length=40)
	private String cidade;
	
	@Column(name="estado", nullable=false, length=2)
	private String estado;
	
	@Column(name="pais", length=40)
	@ColumnDefault("Brasil")
	private String pais;
	
	@Column(name="complemento", length=60)
	private String complemento;
	
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
	
	public Endereco(EnderecoDTO dto) {
		this.nome = dto.getNome();
		this.cep = dto.getCep();
		this.logradouro = dto.getLogradouro();
		this.numero = dto.getNumero();
		this.cidade = dto.getCidade();
		this.complemento = dto.getComplemento();
		this.estado = dto.getEstado();
		this.tipo = dto.getTipo();
		if(dto.getPais()!=null) {
			this.pais = dto.getPais();
		}
	}
	
}
