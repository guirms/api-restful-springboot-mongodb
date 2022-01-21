package com.javaprojeto.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.javaprojeto.workshopmongo.dominios.Usuario;
import com.javaprojeto.workshopmongo.repositorios.UsuarioRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner {
	
	@Autowired
	UsuarioRepositorio usuarioRepo;

	@Override
	public void run(String... args) throws Exception {
		
		usuarioRepo.deleteAll();
		
		Usuario u1 = new Usuario(null, "joao", "joao@hotmail.com");
		Usuario u2 = new Usuario(null, "maria", "maria@hotmail.com");
		
		usuarioRepo.saveAll(Arrays.asList(u1,u2));
;		
		
	}

}
