package com.fiap.hmv.dto.perfil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.fiap.hmv.entity.perfil.Perfil;
import com.fiap.hmv.entity.usuario.Usuario;
import com.fiap.hmv.model.dto.perfil.PerfilDTO;

public class PerfilDTOTest {

	private Long id;
	private String tipo;
	
	@Before
	public void setUp() {
		id = 1L;
    	tipo = "paciente";
	}
	
	@Test
    public void verificarConstrutorPreenchido() {
		PerfilDTO mock = new PerfilDTO(id, tipo);
    	verfificarValoresDefault(mock);
    }
    
    @Test
    public void verificarConstrutorVazio() {
    	PerfilDTO novo = new PerfilDTO();
    	novo.setId(id);
    	novo.setTipo(tipo);
    	verfificarValoresDefault(novo);
    }
    
	@Test
    public void verificarConstrutorPreenchidoPerfil() {
		Usuario usuario = new Usuario(1L, "Paulo", "paulo@gmail.com", "cpf", "01023456754", true, "https://picsum.photos/id/289/200", Calendar.getInstance(), Calendar.getInstance(), null, "trocar@123", null, null, null);
		Perfil perfil = new Perfil(1L, tipo, Calendar.getInstance(), null, usuario);
		PerfilDTO mock = new PerfilDTO(perfil);
    	verfificarValoresDefault(mock);
    }
    
	private void verfificarValoresDefault(PerfilDTO mock) {
		assertEquals(id, mock.getId());
    	assertEquals(tipo, mock.getTipo());
	}
}
