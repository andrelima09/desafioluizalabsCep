package com.br.desafioluizalabs.cep.dto;

import org.springframework.http.HttpStatus;

import com.br.desafioluizalabs.cep.model.Endereco;

import lombok.Data;

@Data
public class ResponseDto {

	private HttpStatus status;
	private Endereco endereco;
	private String erro;
	
}
