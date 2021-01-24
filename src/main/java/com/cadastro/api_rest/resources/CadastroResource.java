package com.cadastro.api_rest.resources;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.api_rest.models.Cadastro;
import com.cadastro.api_rest.repository.CadastroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Cadastro de Pessoa")
@CrossOrigin(origins = "*")
public class CadastroResource {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	@GetMapping("/cadastros")
	@ApiOperation(value = "Retorna uma lista de cadastros.")
	public Page<Cadastro> listaCadastros(Pageable pageable){
		return cadastroRepository.findAll(pageable);
	}
	
	@GetMapping("/cadastro/{id}")
	@ApiOperation(value = "Retorna um cadastro unico.")
	public Cadastro listaCadastroUnico(@PathVariable(value="id") long id){
		return cadastroRepository.findById(id);
	}
	
	@PostMapping("/cadastro")
	@ApiOperation(value = "Salva o cadastro de uma pessoa.")
	public Cadastro salvaCadastro(@RequestBody @Valid Cadastro cadastro) {
		cadastro.getContatos().forEach(c -> c.setCadastro(cadastro));
		return this.cadastroRepository.save(cadastro);
	}
	
	@DeleteMapping("/cadastro")
	@ApiOperation(value = "Deleta o cadastro de uma pessoa.")
	public void deletaCadastro(@RequestBody Cadastro cadastro) {
		cadastroRepository.delete(cadastro);
	}
	
	@PutMapping("/cadastro")
	@ApiOperation(value = "Atualiza o cadastro de uma pessoa.")
	public Cadastro atualizaCadastro(@RequestBody @Valid Cadastro cadastro) {
		cadastro.getContatos().forEach(c -> c.setCadastro(cadastro));
		return cadastroRepository.save(cadastro);
	}
}
