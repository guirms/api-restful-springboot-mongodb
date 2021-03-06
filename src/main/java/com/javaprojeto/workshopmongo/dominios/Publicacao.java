package com.javaprojeto.workshopmongo.dominios;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javaprojeto.workshopmongo.dto.AutorDTO;
import com.javaprojeto.workshopmongo.dto.ComentarioDTO;

@Document
public class Publicacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant data;
	private String titulo;
	private String corpo;

	private AutorDTO autor;

	private List<ComentarioDTO> comentario = new ArrayList<>();

	public Publicacao() {
	}

	public Publicacao(String id, Instant data, String titulo, String corpo, AutorDTO autor) {
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.corpo = corpo;
		this.autor = autor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}

	public List<ComentarioDTO> getComentario() {
		return comentario;
	}

	public void setComentario(List<ComentarioDTO> comentario) {
		this.comentario = comentario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacao other = (Publicacao) obj;
		return Objects.equals(id, other.id);
	}

}
