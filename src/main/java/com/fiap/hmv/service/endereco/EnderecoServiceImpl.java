package com.fiap.hmv.service.endereco;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.hmv.entity.endereco.Endereco;
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
	public List<Endereco> cadastrarListaEndereco(List<EnderecoDTO> lsEnderecoDTO, Usuario usuario) {
		
		List<Endereco> lst = enderecoRepository.saveAll(getListaEnderecos(lsEnderecoDTO));		
		usuarioEnderecoService.cadastrarEnderecoUsuario(lst, usuario);
		
		return lst;
	}

	@Override
	public List<EnderecoDTO> buscarEnderecosPorUsuario(Long idUsuario) {
		List<EnderecoDTO> lstDTO = new ArrayList<EnderecoDTO>();
		List<Endereco> lst = enderecoRepository.buscarEnderecosPorUsuario(idUsuario);
		for (Endereco endereco : lst) {
			lstDTO.add(new EnderecoDTO(endereco));
		}
		return lstDTO;
	}
	
	private List<Endereco> getListaEnderecos(List<EnderecoDTO> lsEnderecoDTO){
		List<Endereco> lstEnderecos = new ArrayList<Endereco>();
		for (EnderecoDTO enderecoDTO : lsEnderecoDTO) {
			lstEnderecos.add(new Endereco(enderecoDTO));
		}
		return lstEnderecos;
	}

}
