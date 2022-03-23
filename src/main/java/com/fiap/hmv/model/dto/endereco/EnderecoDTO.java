package com.fiap.hmv.model.dto.endereco;

import com.fiap.hmv.entity.endereco.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

	private String nome;
	private String logradouro;
	private String tipo;
	private String cep;
	private String numero;
	private String cidade;
	private String estado;
	private String pais;
	private String complemento;
	
	public EnderecoDTO(Endereco endereco) {
		this.nome = endereco.getNome();
		this.cep = endereco.getCep();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.complemento = endereco.getComplemento();
		this.estado = endereco.getEstado();
		this.tipo = endereco.getTipo();
		this.pais = endereco.getPais();
	}

}
