package com.javaprojeto.workshopmongo.recursos.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.javaprojeto.workshopmongo.servicos.excepcitions.ObjetoNaoEncontrado;

@ControllerAdvice // intercepta as exceções
public class ManipuladorExcecoesRecursos {

	@ExceptionHandler(ObjetoNaoEncontrado.class) // identifica e intercepta a excecao requisitada
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontrado e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
}
