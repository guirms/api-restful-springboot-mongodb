package com.javaprojeto.workshopmongo.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaprojeto.workshopmongo.dominios.Usuario;
import com.javaprojeto.workshopmongo.servicos.UsuarioServico;

@RestController	
@RequestMapping(value="/usuarios")
public class UsuarioRecurso {
	
	@Autowired
	private UsuarioServico servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> encontrarTudo(){
		List<Usuario> lista = servico.encontrarTudo();
		return ResponseEntity.ok().body(lista);
	}

}
