package com.fiap.hmv.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Calendar;

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
import com.fiap.hmv.entity.estabelecimento.Estabelecimento;
import com.fiap.hmv.model.dto.endereco.EnderecoDTO;
import com.fiap.hmv.model.dto.estabelecimento.ETipoEstabelecimento;
import com.fiap.hmv.model.dto.estabelecimento.EstabelecimentoDTO;
import com.fiap.hmv.model.dto.estabelecimento.NovoEstabelecimentoDTO;
import com.fiap.hmv.service.estabelecimento.EstabelecimentoService;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class EstabelecimentoControllerTest {

	@Mock
	private EstabelecimentoService estabelecimentoService;
	
	@Spy
	@InjectMocks
	private EstabelecimentoController controller;
	
	@Autowired
	private MockMvc mockMvc;
	
	private EnderecoDTO endereco;
	
	private Estabelecimento estab;
	
	@Before
	public void setup() {
		controller = new EstabelecimentoController(estabelecimentoService);
		
		this.endereco = new EnderecoDTO("Clinica Fiap", "Lins de Vasconcelos", "Avenida", "06266080", "1144", "São Paulo", "SP","Brasil", "torre B");
		this.estab = new Estabelecimento(1L, "Clinica Fiap", "fiap.teste@gmail.com", "11991394584", "93.422.638/0001-00", "https://picsum.photos/id/289/200", "https://picsum.photos/id/289/200", ETipoEstabelecimento.CLINICA.getDescricao(), Calendar.getInstance(), null, null);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void verificarListaEstabelecimentoPorId() throws Exception {
		
		Long id = 1L;
		EstabelecimentoDTO estabelecimentoDTO = new EstabelecimentoDTO(estab, Arrays.asList(endereco));
		
		Mockito.when(estabelecimentoService.buscarPorId(id)).thenReturn(estabelecimentoDTO);
		
		mockMvc.perform(get("/estabelecimentos/1")
			.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.id", is(estab.getId().intValue())))
			.andExpect(jsonPath("$.nome", is(estab.getNome())))
			.andExpect(jsonPath("$.email", is(estab.getEmail())))
			.andExpect(jsonPath("$.telefone", is(estab.getTelefone())))
			.andExpect(jsonPath("$.logo", is(estab.getLogo())))
			.andExpect(jsonPath("$.site", is(estab.getSite())))
			.andExpect(jsonPath("$.tipo", is(ETipoEstabelecimento.getTipoByDescricao(estab.getTipoEstabelecimento()).toString())))
			.andExpect(jsonPath("$.cnpj", is(estab.getCnpj())))
			.andExpect(jsonPath("$.enderecos[0].nome", is(endereco.getNome())))
			.andExpect(jsonPath("$.enderecos[0].logradouro", is(endereco.getLogradouro())))
			.andExpect(jsonPath("$.enderecos[0].tipo", is(endereco.getTipo())))
			.andExpect(jsonPath("$.enderecos[0].cep", is(endereco.getCep())))
			.andExpect(jsonPath("$.enderecos[0].numero", is(endereco.getNumero())))
			.andExpect(jsonPath("$.enderecos[0].cidade", is(endereco.getCidade())))
			.andExpect(jsonPath("$.enderecos[0].estado", is(endereco.getEstado())))
			.andExpect(jsonPath("$.enderecos[0].pais", is(endereco.getPais())))
			.andExpect(jsonPath("$.enderecos[0].complemento", is(endereco.getComplemento())));
		
	}
	
	@Test
	public void verificarCadastroComSucesso() throws Exception {
		NovoEstabelecimentoDTO novoEstabelecimento = getNovoEstabelecimentoDTO();
		EstabelecimentoDTO estabelecimentoDTO = new EstabelecimentoDTO(estab, Arrays.asList(endereco));
		Mockito.when(estabelecimentoService.cadastrar(novoEstabelecimento)).thenReturn(estabelecimentoDTO);
		ResponseEntity<EstabelecimentoDTO> retorno = controller.criar(novoEstabelecimento);
		assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
		assertEquals(estabelecimentoDTO, retorno.getBody());
	}
	
	@Test
	public void verificarRetornoDeErroAoCadastrarComNomeEmBranco() {
		NovoEstabelecimentoDTO novo = getNovoEstabelecimentoDTO();
		novo.setNome("   ");
		validarExcecao(novo, "O campo nome é obrigatório.");
		
	}
	
	@Test
	public void verificarRetornoDeErroAoCadastrarSemNome() {
		NovoEstabelecimentoDTO novo = getNovoEstabelecimentoDTO();
		novo.setNome(null);
		
		validarExcecao(novo, "O campo nome é obrigatório.");
	}
	
	@Test
	public void verificarRetornoDeErroAoCadastrarSemEmail() {
		NovoEstabelecimentoDTO novo = getNovoEstabelecimentoDTO();
		novo.setEmail(null);
		
		validarExcecao(novo, "O campo email é obrigatório.");
	}
	
	@Test
	public void verificarRetornoDeErroAoCadastrarSemCNPJ() {
		NovoEstabelecimentoDTO novo = getNovoEstabelecimentoDTO();
		novo.setCnpj(null);
		validarExcecao(novo, "O campo cnpj é obrigatório.");
		
	}
	
	private void validarExcecao(NovoEstabelecimentoDTO novo, String mensagem) {
		CustomizadoValidacaoCampoException e = assertThrows(CustomizadoValidacaoCampoException.class, () ->
			controller.criar(novo));
		assertEquals(mensagem,e.getMessage());
	}
	
	private NovoEstabelecimentoDTO getNovoEstabelecimentoDTO() {
		return new NovoEstabelecimentoDTO(estab.getNome(), estab.getEmail(), estab.getTelefone(), estab.getCnpj(), estab.getLogo(), estab.getSite(), ETipoEstabelecimento.getTipoByDescricao(estab.getTipoEstabelecimento()), Arrays.asList(endereco));
	}
}
