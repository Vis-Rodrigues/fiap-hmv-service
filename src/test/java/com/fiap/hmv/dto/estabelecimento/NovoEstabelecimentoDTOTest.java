package com.fiap.hmv.dto.estabelecimento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fiap.hmv.model.dto.endereco.EnderecoDTO;
import com.fiap.hmv.model.dto.estabelecimento.ETipoEstabelecimento;
import com.fiap.hmv.model.dto.estabelecimento.NovoEstabelecimentoDTO;

public class NovoEstabelecimentoDTOTest {
	
	private String nome;
	private String email;
	private String telefone;
	private String cnpj;
	private String logo;
	private String site;
	private ETipoEstabelecimento tipo;
	private List<EnderecoDTO> enderecos;
	
    @Before
    public void setUp() {
    	nome = "Clinica Fiap";
    	email = "fiap.teste@gmail.com";
    	telefone = "11991394584";
    	cnpj = "93.422.638/0001-00";
    	site = "https://picsum.photos/id/289/200";
    	logo = "https://picsum.photos/id/289/200";
    	tipo = ETipoEstabelecimento.HOSPITAL;
    	enderecos = Arrays.asList(new EnderecoDTO("Clinica Fiap", "Lins de Vasconcelos", "Avenida", "06266080", "1144", "São Paulo", "SP","Brasil", "torre B"));
    }
    
    @Test
    public void verificarConstrutorPreenchido() {
    	NovoEstabelecimentoDTO novo = new NovoEstabelecimentoDTO(nome, email, telefone, cnpj, logo, site, tipo, enderecos);
    	verfificarValoresDefault(novo);
    }
    
    @Test
    public void verificarConstrutorVazio() {
    	NovoEstabelecimentoDTO novo = new NovoEstabelecimentoDTO();
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
    
	private void verfificarValoresDefault(NovoEstabelecimentoDTO mock) {
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
