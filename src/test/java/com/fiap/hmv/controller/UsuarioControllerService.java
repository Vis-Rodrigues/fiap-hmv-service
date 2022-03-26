package com.fiap.hmv.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fiap.hmv.CustomizadoValidacaoCampoException;
import com.fiap.hmv.entity.perfil.ETipoPerfil;
import com.fiap.hmv.entity.usuario.ETipoDocumento;
import com.fiap.hmv.entity.usuario.Usuario;
import com.fiap.hmv.model.dto.endereco.EnderecoDTO;
import com.fiap.hmv.model.dto.perfil.PerfilDTO;
import com.fiap.hmv.model.dto.usuario.NovoUsuarioDTO;
import com.fiap.hmv.model.dto.usuario.UsuarioDTO;
import com.fiap.hmv.service.usuario.UsuarioService;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioControllerService {
	
	@Mock
	private UsuarioService usuarioService;
	
	@Spy
	@InjectMocks
	private UsuarioController controller;
	
	@Autowired
	private MockMvc mockMvc;
	
	private UsuarioDTO usuarioDTO;
	private List<EnderecoDTO> enderecos;
	private List<PerfilDTO> perfis;
	
	
	private Long idUsuario;
	
	@Before
	public void setup() {
		controller = new UsuarioController(usuarioService);
		idUsuario = 1L;
		Usuario usuario = new Usuario(idUsuario, "Paulo Silas", "paulo.silas@gmail.com", ETipoDocumento.CPF.getDescricao(), "45678952169", true, "https://picsum.photos/id/289/200", Calendar.getInstance(), Calendar.getInstance(), null, null, null, null, null);
		usuarioDTO = new UsuarioDTO(usuario);
    	
		enderecos = Arrays.asList(new EnderecoDTO("Clinica Fiap", "Lins de Vasconcelos", "Avenida", "06266080", "1144", "São Paulo", "SP","Brasil", "torre B"));
    	
		PerfilDTO perfil = new PerfilDTO(1L, ETipoPerfil.PACIENTE.getDescricao());
		perfis = Arrays.asList(perfil);
		
		usuarioDTO.setEnderecos(enderecos);
		usuarioDTO.setPerfis(perfis);

		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void verificarListaUsuarios() throws Exception{
		List<UsuarioDTO> lst = Arrays.asList(usuarioDTO);
		
		Mockito.when(usuarioService.listarUsuarios()).thenReturn(lst);
		
		mockMvc.perform(get("/usuarios")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", is(usuarioDTO.getId().intValue())))
				.andExpect(jsonPath("$[0].nome", is(usuarioDTO.getNome())))
				.andExpect(jsonPath("$[0].docTipo", is(usuarioDTO.getDocTipo().toString())))
				.andExpect(jsonPath("$[0].docNumero", is(usuarioDTO.getDocNumero())));
	}
	
	@Test
	public void verificarConsultaUsuarioPorId() throws Exception {
		
		Mockito.when(usuarioService.buscarPorId(idUsuario)).thenReturn(usuarioDTO);
		
		mockMvc.perform(get("/usuarios/1")
			.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.id", is(usuarioDTO.getId().intValue())))
			.andExpect(jsonPath("$.nome", is(usuarioDTO.getNome())))
			.andExpect(jsonPath("$.email", is(usuarioDTO.getEmail())))
			.andExpect(jsonPath("$.docTipo", is(usuarioDTO.getDocTipo().toString())))
			.andExpect(jsonPath("$.docNumero", is(usuarioDTO.getDocNumero())))
			.andExpect(jsonPath("$.enderecos[0].nome", is(usuarioDTO.getEnderecos().get(0).getNome())))
			.andExpect(jsonPath("$.enderecos[0].logradouro", is(usuarioDTO.getEnderecos().get(0).getLogradouro())))
			.andExpect(jsonPath("$.enderecos[0].tipo", is(usuarioDTO.getEnderecos().get(0).getTipo())))
			.andExpect(jsonPath("$.enderecos[0].cep", is(usuarioDTO.getEnderecos().get(0).getCep())))
			.andExpect(jsonPath("$.enderecos[0].numero", is(usuarioDTO.getEnderecos().get(0).getNumero())))
			.andExpect(jsonPath("$.enderecos[0].cidade", is(usuarioDTO.getEnderecos().get(0).getCidade())))
			.andExpect(jsonPath("$.enderecos[0].estado", is(usuarioDTO.getEnderecos().get(0).getEstado())))
			.andExpect(jsonPath("$.enderecos[0].pais", is(usuarioDTO.getEnderecos().get(0).getPais())))
			.andExpect(jsonPath("$.enderecos[0].complemento", is(usuarioDTO.getEnderecos().get(0).getComplemento())))
			.andExpect(jsonPath("$.perfis[0].id", is(usuarioDTO.getPerfis().get(0).getId().intValue())))
			.andExpect(jsonPath("$.perfis[0].tipo", is(usuarioDTO.getPerfis().get(0).getTipo())));
		
	}
	
	@Test
	public void verificarCadastroComSucesso() throws Exception {
		NovoUsuarioDTO novo = getNovoUsuarioMock();
		Mockito.when(usuarioService.cadastrar(novo)).thenReturn(usuarioDTO);
		ResponseEntity<UsuarioDTO> retorno = controller.criar(novo);
		assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
		assertEquals(usuarioDTO, retorno.getBody());
	}
	
	@Test
	public void verificarCadastroSemEnderecoComSucesso() throws Exception {
		NovoUsuarioDTO novo = getNovoUsuarioMock();
		novo.setEnderecos(null);
		usuarioDTO.setEnderecos(null);
		Mockito.when(usuarioService.cadastrar(novo)).thenReturn(usuarioDTO);
		ResponseEntity<UsuarioDTO> retorno = controller.criar(novo);
		assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
		assertEquals(usuarioDTO, retorno.getBody());
	}
	
	@Test
	public void verificarRetornoDeErroAoCadastrarSemNome() {
		NovoUsuarioDTO novo = getNovoUsuarioMock();
		novo.setNome(null);
		
		validarExcecao(novo, "O campo nome é obrigatório.");
	}
	
	@Test
	public void verificarRetornoDeErroAoCadastrarSemEmail() {
		NovoUsuarioDTO novo = getNovoUsuarioMock();
		novo.setEmail(null);
		
		validarExcecao(novo, "O campo email é obrigatório.");
	}
	
	@Test
	public void verificarRetornoDeErroAoCadastrarSemDocNumero() {
		NovoUsuarioDTO novo = getNovoUsuarioMock();
		novo.setDocNumero(null);
		validarExcecao(novo, "O campo docNumero é obrigatório.");
		
	}
	
	@Test
	public void verificarRetornoDeErroAoCadastrarComNomeEmBranco() {
		NovoUsuarioDTO novo = getNovoUsuarioMock();
		novo.setNome("   ");
		validarExcecao(novo, "O campo nome é obrigatório.");
		
	}
	
	private void validarExcecao(NovoUsuarioDTO novo, String mensagem) {
		CustomizadoValidacaoCampoException e = assertThrows(CustomizadoValidacaoCampoException.class, () ->
			controller.criar(novo));
		assertEquals(mensagem,e.getMessage());
	}
	
	private NovoUsuarioDTO getNovoUsuarioMock() {
		List<String> perfisStr = new ArrayList<>();
		perfisStr.add(ETipoPerfil.PACIENTE.getDescricao());
		return new NovoUsuarioDTO(usuarioDTO.getNome(), usuarioDTO.getEmail(), usuarioDTO.getDocTipo(), usuarioDTO.getDocNumero(), usuarioDTO.getFoto(), enderecos, perfisStr);
	}

}
