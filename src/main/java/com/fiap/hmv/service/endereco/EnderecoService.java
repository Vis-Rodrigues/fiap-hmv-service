package com.fiap.hmv.service.endereco;

import java.util.List;

import com.fiap.hmv.entity.endereco.Endereco;
import com.fiap.hmv.entity.estabelecimento.Estabelecimento;
import com.fiap.hmv.entity.usuario.Usuario;
import com.fiap.hmv.model.dto.endereco.EnderecoDTO;

public interface EnderecoService {
	
	Endereco cadastrar(EnderecoDTO endereco);
	List<Endereco> cadastrarListaEnderecoUsuario(List<EnderecoDTO> lstEnderecos, Usuario usuario);
	List<Endereco> cadastrarListaEnderecoEstabelecimento(List<EnderecoDTO> lstEnderecos, Estabelecimento estabelecimento);
	List<EnderecoDTO> buscarEnderecosPorUsuario(Long idUsuario);
	List<EnderecoDTO> buscarEnderecosPorEstabelecimento(Long idEstabelecimento);

}
