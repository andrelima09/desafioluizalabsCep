package com.br.desafioluizalabs.cep.Mock;

import org.springframework.http.HttpStatus;

import com.br.desafioluizalabs.cep.dto.ResponseDto;
import com.br.desafioluizalabs.cep.model.Endereco;

public class MockDados {

	public static ResponseDto responseDtoOk() {
		ResponseDto response = new ResponseDto();
		response.setStatus(HttpStatus.OK);
		response.setEndereco(MockDados.endereco());
		return response;
	}
	
	public static ResponseDto responseDtoErroRequest() {
		ResponseDto response = new ResponseDto();
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setErro("CEP inválido.");
		return response;
	}
	
	public static ResponseDto responseDtoErroInterno() {
		ResponseDto response = new ResponseDto();
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		response.setErro("Erro interno da aplicação.");
		return response;
	}

	public static Endereco endereco() {
		Endereco endereco = new Endereco();
		endereco.setCep("12345678");
		endereco.setRua("Rua de teste");
		endereco.setCidade("Cidade de teste");
		endereco.setEstado("Estado de teste");
		return endereco;
	}
	
}
