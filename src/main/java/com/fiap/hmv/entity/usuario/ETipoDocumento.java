package com.fiap.hmv.entity.usuario;

import java.util.Arrays;
import java.util.Optional;

public enum ETipoDocumento {
	
	CPF("cpf"),
	CNPJ("cnpj");
	
	private String descricao;
	
	ETipoDocumento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static ETipoDocumento getTipoDocByDescricao(String descricao) {
        Optional<ETipoDocumento> type = Arrays.asList(ETipoDocumento.values()).stream()
                .filter(o -> o.getDescricao() == (descricao)).findFirst();

        return type.isPresent() ? type.get() : null;
    }
}
