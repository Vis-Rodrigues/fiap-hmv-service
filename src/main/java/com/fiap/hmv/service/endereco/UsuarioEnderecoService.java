package com.fiap.hmv.service.endereco;

import java.util.List;

import com.fiap.hmv.entity.endereco.Endereco;
import com.fiap.hmv.entity.usuario.Usuario;
import com.fiap.hmv.entity.usuario.UsuarioEndereco;

public interface UsuarioEnderecoService {

	List<UsuarioEndereco> cadastrarEnderecoUsuario(List<Endereco> lst, Usuario usuario);
}
