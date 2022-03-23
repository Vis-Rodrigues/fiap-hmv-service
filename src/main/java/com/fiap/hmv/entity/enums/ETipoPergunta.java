package com.fiap.hmv.entity.enums;

public enum ETipoPergunta {
	TEXTO("Texto"),
	MULTIPLA_ESCOLHA("Multipla escolha"),
	oPCAO_UNICA("Opcao unica");
	
	private String descricao;
	
	ETipoPergunta(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
