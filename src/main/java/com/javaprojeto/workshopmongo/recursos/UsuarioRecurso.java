package com.javaprojeto.workshopmongo.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaprojeto.workshopmongo.dominios.Usuario;
import com.javaprojeto.workshopmongo.dto.UsuarioDTO;
import com.javaprojeto.workshopmongo.servicos.UsuarioServico;

@RestController	
@RequestMapping(value="/usuarios")
public class UsuarioRecurso {
	
	@Autowired
	private UsuarioServico servico;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> encontrarTudo(){
		List<Usuario> lista = servico.encontrarTudo();
		List<UsuarioDTO> listaDTO = lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> encontrarPorId(@PathVariable String id){
		Usuario usuario = servico.encontrarPorId(id);
		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}

}
