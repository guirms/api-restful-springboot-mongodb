package com.javaprojeto.workshopmongo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaprojeto.workshopmongo.dominios.Usuario;
import com.javaprojeto.workshopmongo.repositorios.UsuarioRepositorio;
import com.javaprojeto.workshopmongo.servicos.excepcitions.ObjetoNaoEncontrado;

@Service
public class UsuarioServico {
	
	@Autowired //injeção automatica do spring (puxa os metodos e as funcoes do repo)
	private UsuarioRepositorio usuarioRepositorio;
	
	public List<Usuario> encontrarTudo(){
		return usuarioRepositorio.findAll();
	}
	
	public Usuario encontrarPorId(String id) { 
		Optional<Usuario> obj = usuarioRepositorio.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontrado(id));
	}

}
