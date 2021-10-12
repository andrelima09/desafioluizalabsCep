package com.br.desafioluizalabs.cep.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

import com.br.desafioluizalabs.cep.Mock.MockDados;
import com.br.desafioluizalabs.cep.dto.ResponseDto;
import com.br.desafioluizalabs.cep.repository.EnderecoRepository;

@ContextConfiguration(classes = EnderecoServiceTest.class)
@WebMvcTest
class EnderecoServiceTest {
	
	@InjectMocks
	private EnderecoService enderecoService;
	
	@Mock
	private EnderecoRepository enderecoRepository;
	
	@BeforeEach
	public void setUp() {
		standaloneSetup(enderecoService);
	}
	
	@Test
	void deveRetornarResponseDtoComStatusOkEEnderecoNaoNulo_QuandoBuscaEnderecoPorCepValidoQueExistaNaBase() {
		String cep = "12345678";
		when(enderecoRepository.findByCep(cep)).thenReturn(MockDados.endereco());
		ResponseDto response = enderecoService.buscaEnderecoPorCep(cep);
		assertTrue(HttpStatus.OK.equals(response.getStatus()) && response.getEndereco() != null);
	}
	
	@Test
	void deveRetornarResponseDtoComStatusOkEEnderecoNulo_QuandoBuscaEnderecoComCepValidoQueNaoExistaNaBase() {
		String cep = "87654321";
		when(enderecoRepository.findByCep(cep)).thenReturn(null);
		ResponseDto response = enderecoService.buscaEnderecoPorCep(cep);
		assertTrue(HttpStatus.OK.equals(response.getStatus()) && response.getEndereco() == null);
	}
	
	@Test
	void deveRetornarResponseDtoComStatusBadRequestEMensagemDeErro_QuandoBuscarEnderecoComCepInvalida() {
		String cepInvalido = "1234567";
		ResponseDto response = enderecoService.buscaEnderecoPorCep(cepInvalido);
		assertTrue(HttpStatus.BAD_REQUEST.equals(response.getStatus()) && response.getErro() != null);
	}
	
	@Test
	void deveRetornarResponseDtoComStatusInternalServerErrorEMensagemDeErro_QuandoOcorrerUmErroDaAplicacao() {
		String cep = "12345678";
		when(enderecoRepository.findByCep(cep)).thenThrow(new RuntimeException());
		ResponseDto response = enderecoService.buscaEnderecoPorCep(cep);
		assertTrue(HttpStatus.INTERNAL_SERVER_ERROR.equals(response.getStatus()) && response.getErro() != null);
	}
	
}
