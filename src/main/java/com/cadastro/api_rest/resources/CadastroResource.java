package com.cadastro.api_rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.api_rest.models.Cadastro;
import com.cadastro.api_rest.models.Contato;
import com.cadastro.api_rest.repository.CadastroRepository;

@RestController
@RequestMapping(value = "/api")
public class CadastroResource {
	
	@Autowired
	CadastroRepository cadastroRepository;
	
	@GetMapping("/cadastros")
	public List<Cadastro> listaCadastros(){
		return cadastroRepository.findAll();
	}
	
	@GetMapping("/cadastro/{id}")
	public Cadastro listaCadastroUnico(@PathVariable(value="id") long id){
		return cadastroRepository.findById(id);
	}
	
	@PostMapping("/cadastro")
	public Cadastro salvaCadastro(@RequestBody Cadastro cadastro) {
		cadastro.getContatos().forEach(c -> c.setCadastro(cadastro));
		return this.cadastroRepository.save(cadastro);
	}
	
	@DeleteMapping("/cadastro")
	public void deletaCadastro(@RequestBody Cadastro cadastro) {
		cadastroRepository.delete(cadastro);
	}
	
	@PutMapping("/cadastro")
	public Cadastro atualizaCadastro(@RequestBody Cadastro cadastro) {
		cadastro.getContatos().forEach(c -> c.setCadastro(cadastro));
		return cadastroRepository.save(cadastro);
	}
}
