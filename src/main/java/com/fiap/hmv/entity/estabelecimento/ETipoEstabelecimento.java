package com.fiap.hmv.entity.estabelecimento;

public enum ETipoEstabelecimento {
	
	HOSPITAL("Hospital"),
	CLINICA("Clínica"),
	PS("Pronto Socorro");
	
	private String descricao;
	
	ETipoEstabelecimento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
