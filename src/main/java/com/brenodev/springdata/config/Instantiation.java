package com.brenodev.springdata.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.brenodev.springdata.model.Usuario;
import com.brenodev.springdata.repository.UsuarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
			Usuario usuario = new Usuario();
			usuario.setEmail("silvabreno462@gmail.com");
			usuario.setIdade(19);
			usuario.setLogin("320055b");
			usuario.setNome("alex");
			usuario.setSenha("brenosilva");
			usuarioRepository.save(usuario);
			
			List<Usuario> list = usuarioRepository.buscaPorNome("alex");
			list.forEach(System.out::println);
		}
		
	}

