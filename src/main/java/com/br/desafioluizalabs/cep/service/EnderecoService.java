package com.br.desafioluizalabs.cep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.br.desafioluizalabs.cep.dto.ResponseDto;
import com.br.desafioluizalabs.cep.model.Endereco;
import com.br.desafioluizalabs.cep.repository.EnderecoRepository;

@Service
public class EnderecoService {

	private static final int TAMANHO_PADRAO_CEP_BRASIL = 8;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public ResponseDto buscaEnderecoPorCep(String cep) {
		ResponseDto response = new ResponseDto();
		cep = cep != null ? cep.replaceAll("[^0-9]", "") : null;
		try {
			if (this.cepValido(cep)) {
				response.setEndereco(this.buscarEnderecoPorCepSubstituindoNumerosADireitaPorZeroSeNecessario(cep));
				response.setStatus(HttpStatus.OK);
			} else {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setErro("CEP inválido.");
			}
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setErro("Ocorreu um erro interno na aplicação.");
		}
		return response;
	}

	private Endereco buscarEnderecoPorCepSubstituindoNumerosADireitaPorZeroSeNecessario(String cep) {
		Endereco endereco;
		int posicao = cep.length();
		while(posicao != 0) {
			 endereco = enderecoRepository.findByCep(cep);
			 if(endereco != null) {
				 return endereco;
			 } else {
				 posicao--;
				 cep = cep.substring(0, posicao) + cep.substring(posicao, cep.length()).replaceAll("[0-9]", "0");
			 }
		}
		return null;
	}

	private boolean cepValido(String cep) {
		return cep != null && cep.length() == TAMANHO_PADRAO_CEP_BRASIL;
	}
	
}
