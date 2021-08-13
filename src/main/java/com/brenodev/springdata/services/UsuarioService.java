package com.brenodev.springdata.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brenodev.springdata.model.Usuario;
import com.brenodev.springdata.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repositorio;
	
	public List<Usuario> buscaPorNome(String nome) {
		return repositorio.buscaPorNome(nome);
	}
	
	public Usuario buscarPorEmail(String email) {
		return repositorio.buscarPorEmail(email);
	}
	public void deletePorNome(String nome) {
		repositorio.deletePorNome(nome);
	}
	
	public void updateEmailPorNome(String email, String nome) {
		repositorio.updateEmailPorNome(email, nome);
	}
}
