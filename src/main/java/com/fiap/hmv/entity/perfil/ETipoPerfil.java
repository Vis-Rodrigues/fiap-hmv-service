package com.fiap.hmv.entity.perfil;

import java.util.Arrays;
import java.util.Optional;

public enum ETipoPerfil {
	MEDICO("medico"),
	PACIENTE("paciente"),
	SOCORRISTA("socorrista");
	
	private String descricao;
	
	ETipoPerfil(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static ETipoPerfil getTipoPorDescricao(String descricao) {
        Optional<ETipoPerfil> type = Arrays.asList(ETipoPerfil.values()).stream()
                .filter(o -> o.getDescricao().equalsIgnoreCase(descricao)).findFirst();

        return type.isPresent() ? type.get() : null;
    }
}
