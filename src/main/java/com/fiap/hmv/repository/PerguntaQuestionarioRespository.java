package com.fiap.hmv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.hmv.entity.questionario.PerguntaQuestionarioEmergencia;

public interface PerguntaQuestionarioRespository extends JpaRepository<PerguntaQuestionarioEmergencia, Long> {

}
