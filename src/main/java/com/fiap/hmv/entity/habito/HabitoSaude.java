package com.fiap.hmv.entity.habito;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fiap.hmv.entity.enums.ESituacao;
import com.fiap.hmv.entity.perfil.Perfil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_habitos_saude")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitoSaude implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8830013193409856598L;

	@Id
	@Column(name="id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="situacao", nullable=false, length=255)
	private ESituacao situacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_at")
	protected Calendar dtCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_at")
	protected Calendar dtAtualizacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="deleted_at")
	protected Calendar dtExclusao;
	
	@OneToOne
	@JoinColumn(name="perfil_id")
	private Perfil perfil;
}
