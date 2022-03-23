package com.fiap.hmv.entity.enums;

public enum ESituacao {
	INCOMPLETO("Incompleto"),
	COMPLETO("Completo");
	
	private String descricao;
	
	ESituacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
