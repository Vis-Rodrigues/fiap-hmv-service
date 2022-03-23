package com.fiap.hmv.model.dto.perfil;

import com.fiap.hmv.entity.perfil.ETipoPerfil;
import com.fiap.hmv.entity.perfil.Perfil;

import lombok.Data;

@Data
public class PerfilDTO {
	
	private ETipoPerfil tipo;
	
	public PerfilDTO(Perfil perfil) {
		this.tipo = ETipoPerfil.getTipoPorDescricao(perfil.getTipo());
	}

}
