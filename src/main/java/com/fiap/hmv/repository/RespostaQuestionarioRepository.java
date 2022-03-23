package com.fiap.hmv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.hmv.entity.questionario.RespostaQuestionarioEmergencia;

public interface RespostaQuestionarioRepository extends JpaRepository<RespostaQuestionarioEmergencia, Long>{

}
