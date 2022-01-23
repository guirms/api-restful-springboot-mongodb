package com.javaprojeto.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.javaprojeto.workshopmongo.dominios.Publicacao;
import com.javaprojeto.workshopmongo.dominios.Usuario;
import com.javaprojeto.workshopmongo.dto.AutorDTO;
import com.javaprojeto.workshopmongo.repositorios.PublicacaoRepositorio;
import com.javaprojeto.workshopmongo.repositorios.UsuarioRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner {
	
	@Autowired
	UsuarioRepositorio usuarioRepo;
	
	@Autowired
	PublicacaoRepositorio publicacaoRepo;

	@Override
	public void run(String... args) throws Exception {
		
		usuarioRepo.deleteAll();
		publicacaoRepo.deleteAll();
		
		Usuario u1 = new Usuario(null, "joao", "joao@hotmail.com");
		Usuario u2 = new Usuario(null, "maria", "maria@hotmail.com");
		
		usuarioRepo.saveAll(Arrays.asList(u1,u2));
		
		Publicacao p1 = new Publicacao(null, Instant.parse("2022-01-23T19:53:07Z"), "Partiu viagem", "Vou pra sp", new AutorDTO(u1));
		Publicacao p2 = new Publicacao(null, Instant.parse("2022-01-23T19:53:07Z"), "Bom dia", "Acordei bem",  new AutorDTO(u2));
		
		publicacaoRepo.saveAll(Arrays.asList(p1,p2));
		
		u1.getPublicacoes().addAll(Arrays.asList(p1, p2));
		usuarioRepo.saveAll(Arrays.asList(u1));
		
	}

}
