package com.fiap.hmv.model.dto.usuario;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiap.hmv.entity.usuario.ETipoDocumento;
import com.fiap.hmv.model.dto.endereco.EnderecoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NovoUsuarioDTO {
	
    @NotBlank(message = "O campo nome é obrigatório.")
    @Size(max = 60, message = "O campo nome pode ter até 60 caracteres.")
	private String nome;
    
    @NotBlank(message = "O campo email é obrigatório.")
    @Size(max = 255, message = "O campo email pode ter até 255 caracteres.")
	private String email;
    
	private ETipoDocumento docTipo;
    
    @NotBlank(message = "O campo docNumero é obrigatório.")
    @Size(max = 20, message = "O campo docNumero pode ter até 20 caracteres.")
	private String docNumero;
    
    @NotBlank(message = "O campo foto é obrigatório.")
    @Size(max = 300, message = "O campo foto pode ter até 300 caracteres.")
	private String foto;
    
	private List<EnderecoDTO> enderecos;
	private List<String> perfis;

}
