package com.brenodev.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brenodev.springdata.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

}
