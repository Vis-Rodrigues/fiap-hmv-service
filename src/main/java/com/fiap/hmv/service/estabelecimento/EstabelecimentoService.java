package com.fiap.hmv.service.estabelecimento;

import com.fiap.hmv.model.dto.estabelecimento.EstabelecimentoDTO;
import com.fiap.hmv.model.dto.estabelecimento.NovoEstabelecimentoDTO;

public interface EstabelecimentoService {
	
	EstabelecimentoDTO cadastrar(NovoEstabelecimentoDTO dto);
	EstabelecimentoDTO buscarPorId(Long id);
}
