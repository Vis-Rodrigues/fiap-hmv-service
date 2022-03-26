package com.fiap.hmv.service.estabelecimento;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.hmv.entity.estabelecimento.Estabelecimento;
import com.fiap.hmv.model.dto.endereco.EnderecoDTO;
import com.fiap.hmv.model.dto.estabelecimento.EstabelecimentoDTO;
import com.fiap.hmv.model.dto.estabelecimento.NovoEstabelecimentoDTO;
import com.fiap.hmv.repository.EstabelecimentoRepository;
import com.fiap.hmv.service.endereco.EnderecoService;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService{
	
	private final EstabelecimentoRepository estabelecimentoRepository;
	
	private final EnderecoService enderecoService;
	
	public EstabelecimentoServiceImpl(EstabelecimentoRepository estabelecimentoRepository, EnderecoService enderecoService) {
		this.estabelecimentoRepository = estabelecimentoRepository;
		this.enderecoService = enderecoService;
	}
	
	@Override
	public EstabelecimentoDTO cadastrar(NovoEstabelecimentoDTO novo) {
		Estabelecimento estabelecimento = estabelecimentoRepository.save(new Estabelecimento(novo));
		if(novo.getEnderecos()!=null && !novo.getEnderecos().isEmpty()) {
			enderecoService.cadastrarListaEnderecoEstabelecimento(novo.getEnderecos(), estabelecimento);
		}
		return new EstabelecimentoDTO(estabelecimento, novo.getEnderecos());
	}

	@Override
	public EstabelecimentoDTO buscarPorId(Long id) {
		Estabelecimento estabelecimento = estabelecimentoRepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		List<EnderecoDTO> lstEnderecos = enderecoService.buscarEnderecosPorEstabelecimento(id);
		return new EstabelecimentoDTO(estabelecimento, lstEnderecos);
	}

}
