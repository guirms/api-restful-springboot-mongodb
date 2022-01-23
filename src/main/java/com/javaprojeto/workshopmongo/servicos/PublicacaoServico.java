package com.javaprojeto.workshopmongo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaprojeto.workshopmongo.dominios.Usuario;
import com.javaprojeto.workshopmongo.dto.UsuarioDTO;
import com.javaprojeto.workshopmongo.repositorios.UsuarioRepositorio;
import com.javaprojeto.workshopmongo.servicos.excepcitions.ObjetoNaoEncontrado;

@Service
public class PublicacaoServico {
	
	@Autowired //injeção automatica do spring (puxa os metodos e as funcoes do repo)
	private UsuarioRepositorio usuarioRepo;
	
	public List<Usuario> encontrarTudo(){
		return usuarioRepo.findAll();
	}
	
	public Usuario encontrarPorId(String id) { 
		Optional<Usuario> obj = usuarioRepo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontrado(id));
	}
	
	public Usuario inserir(Usuario obj) {
		return usuarioRepo.insert(obj);
	}
	
	public void deletar(String id) {
		encontrarPorId(id);
		usuarioRepo.deleteById(id);
	}
	
	public Usuario converterDTO(UsuarioDTO obj) {
		return new Usuario(obj.getId(), obj.getNome(), obj.getEmail());
	}
	
	public Usuario atualizar(Usuario obj) {
		Usuario objNovo = encontrarPorId(obj.getId());
		atualizarDados(objNovo, obj);
		return usuarioRepo.save(objNovo);
	}

	private void atualizarDados(Usuario objNovo, Usuario obj) {
		objNovo.setNome(obj.getNome());
		objNovo.setEmail(obj.getEmail());	
	}
	
}
