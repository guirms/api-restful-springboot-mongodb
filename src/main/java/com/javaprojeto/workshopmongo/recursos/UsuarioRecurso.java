package com.javaprojeto.workshopmongo.recursos;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaprojeto.workshopmongo.dominio.Usuario;

@RestController	
@RequestMapping(value="/usuarios")
public class UsuarioRecurso {
	
	@GetMapping
	public ResponseEntity<List<Usuario>> encontrarTudo(){
		Usuario maria = new Usuario("1", "maria silva", "maria@gmail.com");
		Usuario alex = new Usuario("1", "alex silva", "alex@gmail.com");
		List<Usuario> lista = Arrays.asList(maria, alex);
		return ResponseEntity.ok().body(lista);
	}

}
