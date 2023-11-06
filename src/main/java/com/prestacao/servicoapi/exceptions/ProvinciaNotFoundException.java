package com.prestacao.servicoapi.exceptions;

public class ProvinciaNotFoundException extends RuntimeException {

    public ProvinciaNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
