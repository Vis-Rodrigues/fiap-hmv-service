package com.fiap.hmv.service.usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.hmv.entity.usuario.Usuario;
import com.fiap.hmv.model.dto.endereco.EnderecoDTO;
import com.fiap.hmv.model.dto.perfil.PerfilDTO;
import com.fiap.hmv.model.dto.usuario.NovoUsuarioDTO;
import com.fiap.hmv.model.dto.usuario.UsuarioDTO;
import com.fiap.hmv.repository.UsuarioRepository;
import com.fiap.hmv.service.endereco.EnderecoService;
import com.fiap.hmv.service.perfil.PerfilService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	private final PerfilService perfilService;
	private final EnderecoService enderecoService;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PerfilService perfilService, EnderecoService enderecoService) {
		this.usuarioRepository = usuarioRepository;
		this.perfilService = perfilService;
		this.enderecoService = enderecoService;
	}

	@Override
	public List<UsuarioDTO> listarUsuarios() {
		List<Usuario> lstUsuarios;
		lstUsuarios = usuarioRepository.findAll();

		return lstUsuarios.stream()
			.map(usuario -> new UsuarioDTO(usuario))
			.collect(Collectors.toList());
	}

	@Override
	public UsuarioDTO cadastrar(NovoUsuarioDTO novoUsuarioDTO) {
		Usuario usuario = new Usuario(novoUsuarioDTO);
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		List<PerfilDTO> perfis = cadastrarPerfis(novoUsuarioDTO.getPerfis(), usuarioSalvo);
		if(novoUsuarioDTO.getEnderecos()!=null && !novoUsuarioDTO.getEnderecos().isEmpty()) {
			cadastrarEndereco(novoUsuarioDTO.getEnderecos(), usuarioSalvo);			
		}
		
		return new UsuarioDTO(usuarioSalvo, novoUsuarioDTO.getEnderecos(), perfis);
	}

	@Override
	public UsuarioDTO buscarPorId(Long id) {
		UsuarioDTO dto = new UsuarioDTO(buscar(id));
		dto.setEnderecos(enderecoService.buscarEnderecosPorUsuario(id));
		return dto;
	}
	
	private Usuario buscar(Long id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		return usuario;
	}
	
	
	private void cadastrarEndereco(List<EnderecoDTO> lstEnderecos, Usuario usuario) {
		enderecoService.cadastrarListaEnderecoUsuario(lstEnderecos, usuario);
	}
	
	private List<PerfilDTO> cadastrarPerfis(List<String> lstPerfis, Usuario usuario) {
		return perfilService.convertToListPerfilDTO(perfilService.cadastrarPerfis(lstPerfis, usuario));
	}

	@Override
	public UsuarioDTO buscarDadosPorId(Long id) {
		Usuario usuario = buscar(id);
		List<PerfilDTO> lstPerfis = perfilService.listarPorUsuario(id);
		List<EnderecoDTO> lstEnderecos = enderecoService.buscarEnderecosPorUsuario(id);
		UsuarioDTO dto = new UsuarioDTO(usuario, lstEnderecos, lstPerfis);
		return dto;
	}

}
