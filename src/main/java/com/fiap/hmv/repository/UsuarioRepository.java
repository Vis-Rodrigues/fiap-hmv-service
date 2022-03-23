package com.fiap.hmv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.hmv.entity.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
