package com.fiap.hmv.model.dto.usuario;

import java.util.Calendar;
import java.util.List;

import com.fiap.hmv.entity.usuario.ETipoDocumento;
import com.fiap.hmv.entity.usuario.Usuario;
import com.fiap.hmv.model.dto.endereco.EnderecoDTO;
import com.fiap.hmv.model.dto.perfil.PerfilDTO;

import lombok.Data;

@Data
public class UsuarioDTO {
	
	private Long id;
	private String nome;
	private String email;
	private ETipoDocumento docTipo;
	private String docNumero;
	private boolean ativo;
	private String foto;
	protected Calendar dtEmailVerificado;
	protected Calendar dtCriacao;
	protected Calendar dtAtualizacao;
	private List<EnderecoDTO> enderecos;
	private List<PerfilDTO> perfis;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.docTipo = ETipoDocumento.getTipoDocByDescricao(usuario.getDocTipo());
		this.docNumero = usuario.getDocNumero();
		this.ativo = usuario.isAtivo();
		this.foto = usuario.getFoto();
		this.dtCriacao = usuario.getDtCriacao();
		this.dtAtualizacao = usuario.getDtAtualizacao();
		this.dtEmailVerificado = usuario.getDtEmailVerificado();
	}
	
	public UsuarioDTO(Usuario usuario, List<EnderecoDTO> lstEnderecos, List<PerfilDTO> perfis) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.docTipo = ETipoDocumento.getTipoDocByDescricao(usuario.getDocTipo());
		this.docNumero = usuario.getDocNumero();
		this.ativo = usuario.isAtivo();
		this.foto = usuario.getFoto();
		this.dtCriacao = usuario.getDtCriacao();
		this.dtAtualizacao = usuario.getDtAtualizacao();
		this.dtEmailVerificado = usuario.getDtEmailVerificado();
		this.enderecos = lstEnderecos;
		this.perfis = perfis;
	}

}
