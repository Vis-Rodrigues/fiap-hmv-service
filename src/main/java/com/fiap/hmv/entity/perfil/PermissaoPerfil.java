package com.fiap.hmv.entity.perfil;

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

import com.fiap.hmv.entity.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_permissoes_perfis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissaoPerfil implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3028265940767141037L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
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
	@JoinColumn(name="perfil_id", referencedColumnName="id")
	private Perfil perfil;
}
