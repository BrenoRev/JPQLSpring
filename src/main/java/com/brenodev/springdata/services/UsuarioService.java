package com.brenodev.springdata.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brenodev.springdata.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repositorio;
	
}
