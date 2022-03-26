package com.fiap.hmv.model.dto.perfil;

import com.fiap.hmv.entity.perfil.Perfil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilDTO {
	
	private Long id;
	private String tipo;
	
	public PerfilDTO(Perfil perfil) {
		this.id = perfil.getId();
		this.tipo = perfil.getTipo();
	}

}
