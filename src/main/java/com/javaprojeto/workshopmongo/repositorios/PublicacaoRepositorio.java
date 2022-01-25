package com.javaprojeto.workshopmongo.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaprojeto.workshopmongo.dominios.Publicacao;

@Repository
public interface PublicacaoRepositorio extends MongoRepository<Publicacao, String> {
	
	List<Publicacao> findByTituloContainingIgnoreCase(String texto);
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }") //se isso acontecer, faça o comando abaixo
	List<Publicacao> buscarTitulo(String texto);

	@Query("{ $and: [ { data: {$gte: ?1} }, { data: { $lte: ?2} } , { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } }, { 'comentario.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Publicacao> buscaCompleta(String texto, Date dataInicio, Date dataFim);

}
