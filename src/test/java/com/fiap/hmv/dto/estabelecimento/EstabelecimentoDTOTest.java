package com.fiap.hmv.dto.estabelecimento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fiap.hmv.entity.estabelecimento.Estabelecimento;
import com.fiap.hmv.model.dto.endereco.EnderecoDTO;
import com.fiap.hmv.model.dto.estabelecimento.ETipoEstabelecimento;
import com.fiap.hmv.model.dto.estabelecimento.EstabelecimentoDTO;

public class EstabelecimentoDTOTest {

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
	
	private Estabelecimento estabelecimento;
	
	@Before
	public void setUp() {
		id = 1L;
    	nome = "Clinica Fiap";
    	email = "fiap.teste@gmail.com";
    	telefone = "11991394584";
    	cnpj = "93.422.638/0001-00";
    	site = "https://picsum.photos/id/289/200";
    	logo = "https://picsum.photos/id/289/200";
    	tipo = ETipoEstabelecimento.getTipoByDescricao(ETipoEstabelecimento.HOSPITAL.getDescricao()).name();
    	enderecos = Arrays.asList(new EnderecoDTO("Clinica Fiap", "Lins de Vasconcelos", "Avenida", "06266080", "1144", "São Paulo", "SP","Brasil", "torre B"));
    	dataCriacao = Calendar.getInstance();
    	dataAtualizacao = null;
    	dataExclusao = null;
    	estabelecimento = new Estabelecimento(id, nome, email, telefone, cnpj, logo, site, ETipoEstabelecimento.HOSPITAL.getDescricao(), dataCriacao, dataAtualizacao, dataExclusao);
	}
	
	@Test
    public void verificarConstrutorPreenchido() {
    	EstabelecimentoDTO novo = new EstabelecimentoDTO(id, nome, email, telefone, cnpj, logo, site, tipo, dataCriacao, dataAtualizacao, dataExclusao, enderecos);
    	verfificarValoresDefault(novo);
    }
    
    @Test
    public void verificarConstrutorVazio() {
    	EstabelecimentoDTO novo = new EstabelecimentoDTO();
    	novo.setId(id);
    	novo.setNome(nome);
    	novo.setEmail(email);
    	novo.setTelefone(telefone);
    	novo.setCnpj(cnpj);
    	novo.setSite(site);
    	novo.setLogo(logo);
    	novo.setTipo(tipo);
    	novo.setEnderecos(enderecos);
    	verfificarValoresDefault(novo);
    }
    
	@Test
    public void verificarConstrutorPreenchidoEstabelecimentoEnderecos() {
    	EstabelecimentoDTO novo = new EstabelecimentoDTO(estabelecimento, enderecos);
    	
    	verfificarValoresDefault(novo);
    }
    
	private void verfificarValoresDefault(EstabelecimentoDTO mock) {
		assertEquals(id, mock.getId());
		assertEquals(nome, mock.getNome());
    	assertEquals(email, mock.getEmail());
    	assertEquals(telefone, mock.getTelefone());
    	assertEquals(cnpj, mock.getCnpj());
    	assertEquals(site, mock.getSite());
    	assertEquals(logo, mock.getLogo());
    	assertEquals(tipo, mock.getTipo());
    	assertEquals(enderecos, mock.getEnderecos());
	}
}
