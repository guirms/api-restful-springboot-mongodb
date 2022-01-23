package com.javaprojeto.workshopmongo.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaprojeto.workshopmongo.dominios.Publicacao;

@Repository
public interface PublicacaoRepositorio extends MongoRepository<Publicacao, String> {

}
