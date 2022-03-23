package com.fiap.hmv.service.usuario;

import java.util.List;

import com.fiap.hmv.model.dto.usuario.NovoUsuarioDTO;
import com.fiap.hmv.model.dto.usuario.UsuarioDTO;
import com.fiap.hmv.model.dto.usuario.UsuarioDadosDTO;

public interface UsuarioService {

	List<UsuarioDTO> listarUsuarios();
	UsuarioDTO cadastrar(NovoUsuarioDTO novoUsuarioDTO);
	UsuarioDTO buscarPorId(Long id);
	UsuarioDadosDTO buscarDadosPorId(Long id);
	

}
