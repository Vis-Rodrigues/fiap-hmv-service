package com.fiap.hmv;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CustomizadoValidacaoCampoException extends RuntimeException {

	private static final long serialVersionUID = 1769347950303496322L;
	
	public CustomizadoValidacaoCampoException(List<String> mensagens) {
		super(StringUtils.join(mensagens.toArray(), ","));
	}

}
