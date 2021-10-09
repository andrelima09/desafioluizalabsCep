package com.br.desafioluizalabs.cep.controller;

import static org.mockito.Mockito.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.br.desafioluizalabs.cep.Mock.MockDados;
import com.br.desafioluizalabs.cep.service.EnderecoService;

import io.restassured.http.ContentType;

@WebMvcTest
class EnderecoControllerTest {
	
	@Autowired
	private EnderecoController enderecoController;
	
	@MockBean
	private EnderecoService enderecoService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.enderecoController);
	}
	
	@Test
	void deveRetornarStatusOk_buscarEnderecoComCepValido() {
		String cep = "12605-590";
		when(this.enderecoService.buscaEnderecoPorCep(cep)).thenReturn(MockDados.responseDtoOk());
		given().accept(ContentType.JSON).when().get("/endereco/"+cep).then().statusCode(HttpStatus.OK.value());
	}
	
	@Test
	void deveRetornarStatusErroDaRequisicao_buscarEnderecoComCepInvalido() {
		String cep = "12605-59";
		when(this.enderecoService.buscaEnderecoPorCep(cep)).thenReturn(MockDados.responseDtoErroRequest());
		given().accept(ContentType.JSON).when().get("/endereco/"+cep).then().statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	void deveretornarStatusErroInterno_buscarEndereco() {
		String cep = "12605-590";
		when(this.enderecoService.buscaEnderecoPorCep(cep)).thenReturn(MockDados.responseDtoErroInterno());
		given().accept(ContentType.JSON).when().get("/endereco/"+cep).then().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
}
