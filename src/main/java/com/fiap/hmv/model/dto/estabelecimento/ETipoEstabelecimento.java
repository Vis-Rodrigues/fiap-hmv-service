package com.fiap.hmv.model.dto.estabelecimento;

import java.util.Arrays;
import java.util.Optional;

public enum ETipoEstabelecimento {
	
	HOSPITAL("0"),
	PRONTO_SOCORRO("1"),
	CLINICA("2"),
	OUTROS("3");
	
	private String descricao;
	
	ETipoEstabelecimento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static ETipoEstabelecimento getTipoByDescricao(String descricao) {
        Optional<ETipoEstabelecimento> type = Arrays.asList(ETipoEstabelecimento.values()).stream()
                .filter(o -> o.getDescricao().equals(descricao)).findFirst();

        return type.isPresent() ? type.get() : null;
    }
}
