package com.prestacao.servicoapi.exceptions;

public class CidadeNotFoundException extends RuntimeException {

    public CidadeNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
