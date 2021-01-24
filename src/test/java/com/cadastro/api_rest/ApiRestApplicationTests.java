package com.cadastro.api_rest;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cadastro.api_rest.controller.CadastroResource;
import com.cadastro.api_rest.models.Cadastro;
import com.cadastro.api_rest.models.Contato;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ApiRestApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private CadastroResource cadastroResource;
	
	private Cadastro preparaCadastro() {
		Cadastro pessoa = new Cadastro();
		Contato contato = new Contato();
		
		pessoa.setNome("Larissa Zanata");
		pessoa.setCpf("09358690944");
		pessoa.setDataNascimento(LocalDate.parse("1994-05-11"));
		
		contato.setNome("Bruno Soares");
		contato.setTelefone("998827150");
		contato.setEmail("contatoBruno@gmail.com");
		contato.setCadastro(pessoa);
		
		pessoa.getContatos().add(contato);
		
		return pessoa;
	}
	
	@Test
	void case1() throws Exception{
		
		Cadastro pessoa = preparaCadastro();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/cadastro")
		        .contentType("application/json")
		        .content(objectMapper.writeValueAsString(pessoa)))
		        .andExpect(MockMvcResultMatchers.status().isOk());
		

		
	}



}
