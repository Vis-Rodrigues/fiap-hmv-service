package com.fiap.hmv.service.endereco;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.hmv.entity.endereco.Endereco;
import com.fiap.hmv.entity.estabelecimento.Estabelecimento;
import com.fiap.hmv.entity.usuario.Usuario;
import com.fiap.hmv.model.dto.endereco.EnderecoDTO;
import com.fiap.hmv.repository.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	
	private final EnderecoRepository enderecoRepository;
	private UsuarioEnderecoService usuarioEnderecoService;
	
	@Autowired
	public EnderecoServiceImpl(EnderecoRepository enderecoRepository, UsuarioEnderecoService usuarioEnderecoService) {
		this.enderecoRepository = enderecoRepository;
		this.usuarioEnderecoService = usuarioEnderecoService;
	}

	@Override
	public Endereco cadastrar(EnderecoDTO enderecoDTO) {
		Endereco endereco = new Endereco(enderecoDTO);
		return enderecoRepository.save(endereco);
	}

	@Override
	public List<Endereco> cadastrarListaEnderecoUsuario(List<EnderecoDTO> lsEnderecoDTO, Usuario usuario) {
		
		List<Endereco> lst = enderecoRepository.saveAll(getListaEnderecos(lsEnderecoDTO));		
		usuarioEnderecoService.cadastrarEnderecoUsuario(lst, usuario);
		
		return lst;
	}

	@Override
	public List<EnderecoDTO> buscarEnderecosPorUsuario(Long idUsuario) {
		List<Endereco> lst = enderecoRepository.buscarEnderecosPorUsuario(idUsuario);
		return lst.stream()
				.map(endereco -> new EnderecoDTO(endereco))
				.collect(Collectors.toList());
	}
	
	private List<Endereco> getListaEnderecos(List<EnderecoDTO> lstEnderecoDTO){
		return lstEnderecoDTO.stream()
				.map(enderecoDTO -> new Endereco(enderecoDTO))
				.collect(Collectors.toList());
	}

	@Override
	public List<Endereco> cadastrarListaEnderecoEstabelecimento(List<EnderecoDTO> lstEnderecos,
			Estabelecimento estabelecimento) {
		List<Endereco> lst = enderecoRepository.saveAll(getListaEnderecos(lstEnderecos));		
		usuarioEnderecoService.cadastrarEnderecoEstabelecimento(lst, estabelecimento);
		
		return lst;
	}

	@Override
	public List<EnderecoDTO> buscarEnderecosPorEstabelecimento(Long idEstabelecimento) {
		List<Endereco> lst = enderecoRepository.buscarEnderecosPorEstabelecimento(idEstabelecimento);
		return lst.stream()
				.map(endereco -> new EnderecoDTO(endereco))
				.collect(Collectors.toList());
	}

}
