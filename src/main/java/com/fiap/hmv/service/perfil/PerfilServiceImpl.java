package com.fiap.hmv.service.perfil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fiap.hmv.entity.perfil.Perfil;
import com.fiap.hmv.entity.usuario.Usuario;
import com.fiap.hmv.model.dto.perfil.PerfilDTO;
import com.fiap.hmv.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService {

	private final PerfilRepository perfilRepository;
	
	public PerfilServiceImpl(PerfilRepository perfilRepository) {
		this.perfilRepository = perfilRepository;
	}
	
	@Override
	public List<PerfilDTO> listarPorUsuario(Long usuarioId) {
		List<Perfil> lst = perfilRepository.findAllByUsuarioId(usuarioId);
		
		return convertToListPerfilDTO(lst);
	}

	@Override
	public List<Perfil> cadastrarPerfis(List<String> lstDTOs, Usuario usuario) {
		List<Perfil> lstPerfis = new ArrayList<Perfil>();
		for (String perfil: lstDTOs) {
			lstPerfis.add(new Perfil(perfil.toLowerCase(), usuario));
		}
		lstPerfis = perfilRepository.saveAll(lstPerfis);
		return lstPerfis;
	}
	
	@Override
	public List<PerfilDTO> convertToListPerfilDTO(List<Perfil> perfis){
		return perfis.stream()
				.map(perfil -> new PerfilDTO(perfil))
				.collect(Collectors.toList());
	}

}
