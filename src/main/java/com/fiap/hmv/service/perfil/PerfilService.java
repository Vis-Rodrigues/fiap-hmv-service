package com.fiap.hmv.service.perfil;

import java.util.List;

import com.fiap.hmv.entity.perfil.Perfil;
import com.fiap.hmv.entity.usuario.Usuario;
import com.fiap.hmv.model.dto.perfil.PerfilDTO;

public interface PerfilService {
	
	List<PerfilDTO> listarPorUsuario(Long id);
	List<Perfil> cadastrarPerfis(List<String> lsDTOs, Usuario usuario);

}
