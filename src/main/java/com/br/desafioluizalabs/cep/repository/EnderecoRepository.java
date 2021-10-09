package com.br.desafioluizalabs.cep.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.desafioluizalabs.cep.model.Endereco;

public interface EnderecoRepository extends MongoRepository<Endereco, String>{

	Endereco findByCep(String cep);
}
