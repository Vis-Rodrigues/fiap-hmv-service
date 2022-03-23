package com.fiap.hmv.model.dto.usuario;

import java.util.List;

import com.fiap.hmv.entity.usuario.ETipoDocumento;
import com.fiap.hmv.model.dto.endereco.EnderecoDTO;

import lombok.Data;

@Data
public class NovoUsuarioDTO {
	
	private String nome;
	private String email;
	private ETipoDocumento docTipo;
	private String docNumero;
	private String foto;
	private List<EnderecoDTO> enderecos;
	private List<String> perfis;

}
