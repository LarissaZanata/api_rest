package com.cadastro.api_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.api_rest.models.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro , Long>{
	
	Cadastro findById(long id);
}
