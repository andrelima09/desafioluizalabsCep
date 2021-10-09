package com.br.desafioluizalabs.cep.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Endereco {

	@Id
	private String codigo;
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	
}
