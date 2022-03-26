package com.fiap.hmv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.hmv.model.dto.estabelecimento.EstabelecimentoDTO;
import com.fiap.hmv.model.dto.estabelecimento.NovoEstabelecimentoDTO;
import com.fiap.hmv.service.estabelecimento.EstabelecimentoService;

import static com.fiap.hmv.utils.ValidacaoUtil.validar;

@RestController
@RequestMapping("estabelecimentos")
public class EstabelecimentoController {
	
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	public EstabelecimentoController(EstabelecimentoService estabelecimentoService) {
		this.estabelecimentoService = estabelecimentoService;
	}

	@GetMapping("/{id}")
	public EstabelecimentoDTO buscarPorId(@PathVariable Long id) {
		return estabelecimentoService.buscarPorId(id);
	}
	
	@PostMapping
	public ResponseEntity<EstabelecimentoDTO> criar(@RequestBody NovoEstabelecimentoDTO dto) {
		validar(dto);
		EstabelecimentoDTO retorno = estabelecimentoService.cadastrar(dto);
		return new ResponseEntity<>(retorno, HttpStatus.CREATED);
	}

}
