package com.javaprojeto.workshopmongo.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaprojeto.workshopmongo.dominios.Usuario;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {

}
