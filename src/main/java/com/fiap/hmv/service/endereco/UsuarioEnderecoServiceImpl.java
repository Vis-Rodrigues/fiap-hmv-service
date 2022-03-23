package com.fiap.hmv.service.endereco;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.hmv.entity.endereco.Endereco;
import com.fiap.hmv.entity.usuario.Usuario;
import com.fiap.hmv.entity.usuario.UsuarioEndereco;
import com.fiap.hmv.repository.UsuarioEnderecoRepository;

@Service
public class UsuarioEnderecoServiceImpl implements UsuarioEnderecoService {
	
	private final UsuarioEnderecoRepository usuarioEnderecoRepository;
	
	@Autowired
	public UsuarioEnderecoServiceImpl(UsuarioEnderecoRepository usuarioEnderecoRepository) {
		this.usuarioEnderecoRepository = usuarioEnderecoRepository;
	}

	@Override
	public List<UsuarioEndereco> cadastrarEnderecoUsuario(List<Endereco> lst, Usuario usuario) {
		List<UsuarioEndereco> lstUsuarioEnderecos = new ArrayList<>();
		for (Endereco endereco : lst) {
			lstUsuarioEnderecos.add(usuarioEnderecoRepository.save(new UsuarioEndereco(usuario, endereco)));
		}
		return lstUsuarioEnderecos;
	}

}
