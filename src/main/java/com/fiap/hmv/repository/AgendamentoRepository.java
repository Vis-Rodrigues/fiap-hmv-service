package com.fiap.hmv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.hmv.entity.agendamento.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
