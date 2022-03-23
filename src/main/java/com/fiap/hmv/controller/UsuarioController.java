package com.fiap.hmv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.hmv.model.dto.usuario.NovoUsuarioDTO;
import com.fiap.hmv.model.dto.usuario.UsuarioDTO;
import com.fiap.hmv.model.dto.usuario.UsuarioDadosDTO;
import com.fiap.hmv.service.perfil.PerfilService;
import com.fiap.hmv.service.usuario.UsuarioService;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping
	public List<UsuarioDTO> listarUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
	@GetMapping("{id}")
	public UsuarioDTO buscarPorId(@PathVariable Long id) {
		return usuarioService.buscarPorId(id);
	}
	
	@GetMapping("/dados/{id}")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public UsuarioDadosDTO buscarDadosPorId(@PathVariable Long id) {
		return usuarioService.buscarDadosPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDTO criar(@RequestBody NovoUsuarioDTO novoUsuarioDTO) {
		return usuarioService.cadastrar(novoUsuarioDTO);
	}
}
