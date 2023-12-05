package com.prestacao.servicoapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.prestacao.servicoapi.exceptions.CidadeNotFoundException;
import com.prestacao.servicoapi.exceptions.ClienteNotFoundException;
import com.prestacao.servicoapi.exceptions.EnderecoNotFoundException;
import com.prestacao.servicoapi.exceptions.ProvinciaNotFoundException;
import com.prestacao.servicoapi.exceptions.ServicoPrestadoNotFoundException;
import com.prestacao.servicoapi.exceptions.TipoServicoException;
import com.prestacao.servicoapi.exceptions.TipoServicoFoundException;
import com.prestacao.servicoapi.exceptions.UsuarioCadastradoException;
import com.prestacao.servicoapi.exceptions.UsuarioNotFoundException;
import com.prestacao.servicoapi.exceptions.UsuarioPerfilNotFoundException;
import com.prestacao.servicoapi.utils.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	private String mensagemErro;

	@ResponseBody
	@ExceptionHandler(ServicoPrestadoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors servicoPrestadoNotFoundExceptionHandle(ServicoPrestadoNotFoundException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(UsuarioCadastradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors usuarioCadastradoExceptionHandle(UsuarioCadastradoException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(UsuarioPerfilNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors usuarioPerfilNotFoundExceptionHandle(UsuarioPerfilNotFoundException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(ClienteNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors clienteNotFoundExceptionHandle(ClienteNotFoundException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(TipoServicoFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors tipoServicoFoundExceptionHandle(TipoServicoFoundException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(UsuarioNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors usuarioNotFoundExceptionHandle(
			UsuarioNotFoundException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(TipoServicoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors tipoServicoExceptionHandle(
			TipoServicoException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(CidadeNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors cidadeNotFoundExceptionHandle(
			CidadeNotFoundException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(EnderecoNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors enderecoNotFoundExceptionHandle(
			EnderecoNotFoundException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(ProvinciaNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors provinciaNotFoundExceptionHandle(
			ProvinciaNotFoundException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity ResponseStatusExceptionHandle(ResponseStatusException ex) {
		String messagemErro = ex.getReason();
		HttpStatus codigoStatus = ex.getStatus();
		ApiErrors apiErrors = new ApiErrors(messagemErro);
		return new ResponseEntity(apiErrors, codigoStatus);

	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors validateFieldsHandle(MethodArgumentNotValidException ex) {
		List<String> erros = ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());

		return new ApiErrors(erros);
	}
}
