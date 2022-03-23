package com.fiap.hmv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.hmv.entity.perfil.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
	
	List<Perfil> findAllByUsuarioId(Long usuarioId);

}
