package com.javaprojeto.workshopmongo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaprojeto.workshopmongo.dominios.Publicacao;
import com.javaprojeto.workshopmongo.repositorios.PublicacaoRepositorio;
import com.javaprojeto.workshopmongo.servicos.excepcitions.ObjetoNaoEncontrado;

@Service
public class PublicacaoServico {
	
	@Autowired //injeção automatica do spring (puxa os metodos e as funcoes do repo)
	private PublicacaoRepositorio publicacaoRepo;

	public Publicacao encontrarPorId(String id) { 
		Optional<Publicacao> obj = publicacaoRepo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontrado(id));
	}
	
	public List<Publicacao> econtrarPorTitulo(String texto){
		return publicacaoRepo.findByTituloContainingIgnoreCase(texto);
	}
	
}
