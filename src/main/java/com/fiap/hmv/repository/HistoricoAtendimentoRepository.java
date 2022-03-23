package com.fiap.hmv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.hmv.entity.agendamento.HistoricoAtendimento;

public interface HistoricoAtendimentoRepository extends JpaRepository<HistoricoAtendimento, Long> {

}
