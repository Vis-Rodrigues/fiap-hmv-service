package com.fiap.hmv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fiap.hmv.entity.endereco.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	@Query("select e from Endereco e inner join UsuarioEndereco ase on ase.endereco.id = e.id where ase.usuario.id = :id")
	List<Endereco> buscarEnderecosPorUsuario(@Param("id") Long id);
	
	@Query("select e from Endereco e inner join UsuarioEndereco ase on ase.endereco.id = e.id where ase.estabelecimento.id = :id")
	List<Endereco> buscarEnderecosPorEstabelecimento(@Param("id") Long id);
}
