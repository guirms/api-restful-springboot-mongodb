package com.javaprojeto.workshopmongo.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javaprojeto.workshopmongo.dominios.Publicacao;
import com.javaprojeto.workshopmongo.dominios.Usuario;
import com.javaprojeto.workshopmongo.dto.UsuarioDTO;
import com.javaprojeto.workshopmongo.servicos.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {

	@Autowired
	private UsuarioServico servico;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> encontrarTudo() {
		List<Usuario> lista = servico.encontrarTudo();
		List<UsuarioDTO> listaDTO = lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> encontrarPorId(@PathVariable String id) {
		Usuario usuario = servico.encontrarPorId(id);
		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO objDTO) {
		Usuario usuario = servico.converterDTO(objDTO);
		servico.inserir(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build(); // para criar o corpo com o codigo 201 created
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable String id) {
		servico.deletar(id);
		return ResponseEntity.noContent().build(); // para retornar sem corpo
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable String id, @RequestBody UsuarioDTO objDTO) {
		Usuario usuario = servico.converterDTO(objDTO);
		usuario.setId(id);
		usuario = servico.atualizar(usuario);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}/pubs")
	public ResponseEntity<List<Publicacao>> encontrarPublicacoes(@PathVariable String id) {
		Usuario usuario = servico.encontrarPorId(id);
		return ResponseEntity.ok().body(usuario.getPublicacoes());
	}

}
