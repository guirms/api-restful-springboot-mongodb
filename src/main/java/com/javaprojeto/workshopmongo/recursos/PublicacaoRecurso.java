package com.javaprojeto.workshopmongo.recursos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaprojeto.workshopmongo.dominios.Publicacao;
import com.javaprojeto.workshopmongo.recursos.util.URL;
import com.javaprojeto.workshopmongo.servicos.PublicacaoServico;

@RestController
@RequestMapping(value = "/pubs")
public class PublicacaoRecurso {

	@Autowired
	private PublicacaoServico servico;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Publicacao> encontrarPorId(@PathVariable String id) {
		Publicacao pub = servico.encontrarPorId(id);
		return ResponseEntity.ok().body(pub);
	}

	@GetMapping(value = "/titulo")
	public ResponseEntity<List<Publicacao>> encontrarPorTitulo(
			@RequestParam(value = "text", defaultValue = "") String texto) {
		texto = URL.decodificarParam(texto);
		List<Publicacao> lista = servico.econtrarPorTitulo(texto);
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/busca")
	public ResponseEntity<List<Publicacao>> buscaCompleta(
			@RequestParam(value = "text", defaultValue = "") String texto,
			@RequestParam(value = "dataInicio", defaultValue = "") String dataInicio,
			@RequestParam(value = "dataFim", defaultValue = "") String dataFim) {
		texto = URL.decodificarParam(texto);
		Date inicio = URL.converterData(dataInicio, new Date(0L));
		Date fim = URL.converterData(dataFim, new Date());
		List<Publicacao> lista = servico.buscaCompleta(texto, inicio, fim);
		return ResponseEntity.ok().body(lista);
	}

}
