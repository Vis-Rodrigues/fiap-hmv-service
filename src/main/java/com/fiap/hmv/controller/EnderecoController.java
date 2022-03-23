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
import org.springframework.web.bind.annotation.RestController;

import com.fiap.hmv.model.dto.endereco.EnderecoDTO;
import com.fiap.hmv.service.endereco.EnderecoService;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody EnderecoDTO enderecoDTO) {
		enderecoService.cadastrar(enderecoDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/usuario/{id}")
	public List<EnderecoDTO> buscarPorUsuarioId(@PathVariable Long id) {
		return enderecoService.buscarEnderecosPorUsuario(id);
	}

	
}
