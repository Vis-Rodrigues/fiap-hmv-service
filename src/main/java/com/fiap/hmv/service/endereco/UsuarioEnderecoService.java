package com.fiap.hmv.service.endereco;

import java.util.List;

import com.fiap.hmv.entity.endereco.Endereco;
import com.fiap.hmv.entity.endereco.UsuarioEndereco;
import com.fiap.hmv.entity.estabelecimento.Estabelecimento;
import com.fiap.hmv.entity.usuario.Usuario;

public interface UsuarioEnderecoService {

	List<UsuarioEndereco> cadastrarEnderecoUsuario(List<Endereco> lst, Usuario usuario);
	List<UsuarioEndereco> cadastrarEnderecoEstabelecimento(List<Endereco> lst, Estabelecimento estabelecimento);
}
