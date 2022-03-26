package com.fiap.hmv.dto.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fiap.hmv.entity.usuario.ETipoDocumento;
import com.fiap.hmv.model.dto.endereco.EnderecoDTO;
import com.fiap.hmv.model.dto.usuario.NovoUsuarioDTO;

public class NovoUsuarioDTOTest {
	
	private String nome;
	private String email;
	private ETipoDocumento docTipo;
	private String docNumero;
	private String foto;
	private List<EnderecoDTO> enderecos;
	private List<String> perfis;
	
	@Before
	public void setUp() {
		nome = "Paulo Silas";
    	email = "paulo.silas@gmail.com";
    	docTipo = ETipoDocumento.CPF;
    	docNumero = "42345058743";
    	foto = "https://picsum.photos/id/289/200";
    	enderecos = Arrays.asList(new EnderecoDTO("Clinica Fiap", "Lins de Vasconcelos", "Avenida", "06266080", "1144", "São Paulo", "SP","Brasil", "torre B"));
    	perfis = Arrays.asList("paciente");
	}
	
	@Test
    public void verificarConstrutorPreenchido() {
		NovoUsuarioDTO mock = new NovoUsuarioDTO(nome, email, docTipo, docNumero, foto, enderecos, perfis);
    	verfificarValoresDefault(mock);
    }
    
    @Test
    public void verificarConstrutorVazio() {
    	NovoUsuarioDTO novo = new NovoUsuarioDTO();
    	novo.setNome(nome);
    	novo.setDocNumero(docNumero);
    	novo.setDocTipo(docTipo);
    	novo.setEmail(email);
    	novo.setEnderecos(enderecos);
    	novo.setFoto(foto);
    	novo.setPerfis(perfis);
    	verfificarValoresDefault(novo);
    }
    
	private void verfificarValoresDefault(NovoUsuarioDTO mock) {
		assertEquals(nome, mock.getNome());
    	assertEquals(email, mock.getEmail());
    	assertEquals(docTipo, mock.getDocTipo());
    	assertEquals(docNumero, mock.getDocNumero());
    	assertEquals(foto, mock.getFoto());
    	assertEquals(enderecos, mock.getEnderecos());
    	assertEquals(perfis, mock.getPerfis());
	}
}
