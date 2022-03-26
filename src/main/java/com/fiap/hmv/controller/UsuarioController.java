package com.fiap.hmv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.hmv.model.dto.usuario.NovoUsuarioDTO;
import com.fiap.hmv.model.dto.usuario.UsuarioDTO;
import com.fiap.hmv.service.usuario.UsuarioService;

import static com.fiap.hmv.utils.ValidacaoUtil.validar;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

	private UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<UsuarioDTO> listarUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
	@GetMapping("{id}")
	public UsuarioDTO buscarPorId(@PathVariable Long id) {
		return usuarioService.buscarPorId(id);
	}
	
	@GetMapping("/dados/{id}")
	public UsuarioDTO buscarDadosPorId(@PathVariable Long id) {
		return usuarioService.buscarDadosPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UsuarioDTO> criar(@RequestBody NovoUsuarioDTO novoUsuarioDTO) {
		validar(novoUsuarioDTO);
		UsuarioDTO retorno = usuarioService.cadastrar(novoUsuarioDTO);
		return new ResponseEntity<UsuarioDTO>(retorno, HttpStatus.CREATED);
	}
}
