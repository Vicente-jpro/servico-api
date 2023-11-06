package com.prestacao.servicoapi.exceptions;

public class EnderecoNotFoundException extends RuntimeException {
    public EnderecoNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
