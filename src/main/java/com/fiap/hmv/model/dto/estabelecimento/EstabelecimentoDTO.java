package com.fiap.hmv.model.dto.estabelecimento;

import java.util.Calendar;
import java.util.List;

import com.fiap.hmv.entity.estabelecimento.Estabelecimento;
import com.fiap.hmv.model.dto.endereco.EnderecoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstabelecimentoDTO{

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cnpj;
	private String logo;
	private String site;
	private String tipo;
	private Calendar dataCriacao;
	private Calendar dataAtualizacao;
	private Calendar dataExclusao;
	private List<EnderecoDTO> enderecos;
	
	public EstabelecimentoDTO(Estabelecimento e, List<EnderecoDTO> enderecos) {
		this.id = e.getId();
		this.nome = e.getNome();
		this.email = e.getEmail();
		this.telefone = e.getTelefone();
		this.cnpj = e.getCnpj();
		this.logo = e.getLogo();
		this.site = e.getSite();
		this.dataCriacao = e.getDtCriacao();
		this.dataAtualizacao = e.getDtAtualizacao();
		this.dataExclusao = e.getDtExclusao();
		this.tipo = ETipoEstabelecimento.getTipoByDescricao(e.getTipoEstabelecimento()).toString();
		this.enderecos = enderecos;
	}
	
}
