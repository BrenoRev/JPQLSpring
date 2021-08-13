package com.brenodev.springdata.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.brenodev.springdata.repository.TelefoneRepository;

public class TelefoneService {

	@Autowired
	TelefoneRepository telefoneRepository;
}
