package com.brenodev.springdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brenodev.springdata.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query(value = "SELECT p FROM Usuario p WHERE p.nome like %?1%")
	public List<Usuario> buscaPorNome(String nome);
	
	@Query(value= "SELECT p FROM Usuario p where p.email= :paramEmail")
	public Usuario buscarPorEmail(@Param("paramEmail") String paramEmail);
}
