package com.br.desafioluizalabs.cep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.desafioluizalabs.cep.dto.ResponseDto;
import com.br.desafioluizalabs.cep.service.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/endereco")
@Api
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@ApiOperation(value = "Busca endereço pelo CEP.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requisição feita com sucesso."),
			@ApiResponse(code = 500, message = "Erro interno da aplicação."),
			@ApiResponse(code = 400, message = "Cep inválido.")})
	@GetMapping("/{cep}")
	public ResponseEntity<ResponseDto> buscaEnderecoPorCep(@PathVariable String cep) {
		ResponseDto response = enderecoService.buscaEnderecoPorCep(cep);
		return new ResponseEntity<>(response, response.getStatus());
	}
}
