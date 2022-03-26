package com.fiap.hmv.model.dto.estabelecimento;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fiap.hmv.model.dto.endereco.EnderecoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NovoEstabelecimentoDTO {

    @NotBlank(message = "O campo nome é obrigatório.")
    @Size(max = 60, message = "O campo nome pode ter até 60 caracteres.")
	private String nome;
    
    @NotBlank(message = "O campo email é obrigatório.")
    @Size(max = 60, message = "O campo email pode ter até 60 caracteres.")
	private String email;
    
    @Size(max = 15, message = "O campo telefone pode ter até 15 caracteres.")
	private String telefone;
    
    @NotBlank(message = "O campo cnpj é obrigatório.")
    @Size(max = 25, message = "O campo cnpj pode ter até 25 caracteres.")
	private String cnpj;
    
    @Size(max = 300, message = "O campo logo pode ter até 300 caracteres.")
	private String logo;
    
    @Size(max = 300, message = "O campo site pode ter até 300 caracteres.")
	private String site;
    
	private ETipoEstabelecimento tipo;
	private List<EnderecoDTO> enderecos;

}
