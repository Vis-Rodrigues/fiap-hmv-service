package com.fiap.hmv.service;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.fiap.hmv.entity.usuario.ETipoDocumento;
import com.fiap.hmv.entity.usuario.Usuario;
import com.fiap.hmv.model.dto.usuario.UsuarioDTO;
import com.fiap.hmv.repository.UsuarioRepository;
import com.fiap.hmv.service.endereco.EnderecoService;
import com.fiap.hmv.service.perfil.PerfilService;
import com.fiap.hmv.service.usuario.UsuarioServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceImplTest {
	
	@Mock
    private UsuarioRepository usuarioRepository;
	
	@Mock
	private EnderecoService enderecoService;
	
	@Mock
	private PerfilService perfilService;

	@Spy
    @InjectMocks
    private UsuarioServiceImpl service;
	
	private Usuario usuario;
	
	private final Long idUsuario = 1L;
	
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
    	usuario = new Usuario(idUsuario, "Paulo Silas", "paulo.silas@gmail.com", ETipoDocumento.CPF.getDescricao(), "45678952169", true, "https://picsum.photos/id/289/200", Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), null, null, null, null);
        service = new UsuarioServiceImpl(usuarioRepository, perfilService, enderecoService);
    }
    
    @Test
    public void verificarBuscaUsuarioPorIdComSucesso(){
        Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(Optional.of(usuario));
        
        UsuarioDTO usuarioDTO = service.buscarPorId(idUsuario);

        assertEquals(usuarioDTO.getId(), usuario.getId());
        assertEquals(usuarioDTO.getNome(), usuario.getNome());
        assertEquals(usuarioDTO.getEmail(), usuario.getEmail());
        assertEquals(usuarioDTO.getFoto(), usuario.getFoto());
        assertEquals(usuarioDTO.getDocTipo().getDescricao(), usuario.getDocTipo());
        assertEquals(usuarioDTO.getDocNumero(), usuario.getDocNumero());
    }
    
}
