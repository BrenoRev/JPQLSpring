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
			usuario.setEmail("xuxinha@gmail.com");
			usuario.setIdade(27);
			usuario.setLogin("2321breno");
			usuario.setNome("xuxa2");
			usuario.setSenha("2323");
			usuarioRepository.save(usuario);
			
			//List<Usuario> list = usuarioRepository.buscaPorNome("alex");
			//list.forEach(System.out::println);
			
			//Usuario usuarioEmail = usuarioRepository.buscarPorEmail("xuba@gmail.com");
			//System.out.println(usuarioEmail.toString());
			
			List<Usuario> list = usuarioRepository.buscaPorNome("xuxa2");
			list.forEach(System.out::println);
			
			usuarioRepository.deletePorNome("xuxa2");
			List<Usuario> list1 = usuarioRepository.buscaPorNome("xuxa2");
			list1.forEach(System.out::println);
		}
		
	}

