package com.br.desafioluizalabs.cep;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.desafioluizalabs.cep.controller.EnderecoController;
import com.br.desafioluizalabs.cep.repository.EnderecoRepository;
import com.br.desafioluizalabs.cep.service.EnderecoService;

@SpringBootTest
class CepApplicationTests {

	@Autowired
	private EnderecoController enderecoController;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private EnderecoRepository enderecorepository;
	
	@Test
	void contextLoads() {
		assertThat(enderecoController).isNotNull();
		assertThat(enderecoService).isNotNull();
		assertThat(enderecorepository).isNotNull();
	}

}
