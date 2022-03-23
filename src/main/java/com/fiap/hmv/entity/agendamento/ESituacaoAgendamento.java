package com.fiap.hmv.entity.agendamento;

public enum ESituacaoAgendamento {
	AGENDADO("Agendado"),
	EM_ESPERA("Em espera"),
	EM_REALIZACAO("Em realização"),
	REALIZADO("Realizado"),
	NAO_REALIZADO("Não Realizado");
	
	private String descricao;
	
	ESituacaoAgendamento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
