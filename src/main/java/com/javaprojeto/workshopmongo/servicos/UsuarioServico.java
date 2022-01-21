package com.javaprojeto.workshopmongo.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaprojeto.workshopmongo.dominios.Usuario;
import com.javaprojeto.workshopmongo.recursos.UsuarioRecurso;
import com.javaprojeto.workshopmongo.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {
	
	@Autowired //injeção automatica do spring (puxa os metodos e as funcoes do repo)
	private UsuarioRepositorio usuarioRepositorio;
	
	public List<Usuario> encontrarTudo(){
		return usuarioRepositorio.findAll();
	}

}
