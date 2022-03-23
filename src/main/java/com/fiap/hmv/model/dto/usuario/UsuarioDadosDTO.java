package com.fiap.hmv.model.dto.usuario;

import java.util.List;

import com.fiap.hmv.entity.usuario.Usuario;
import com.fiap.hmv.model.dto.perfil.PerfilDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDadosDTO extends UsuarioDTO {

	private List<PerfilDTO> perfis;
	
	public UsuarioDadosDTO(Usuario usuario, List<PerfilDTO> perfis) {
		super(usuario);
		this.perfis = perfis;
	}

	
}
