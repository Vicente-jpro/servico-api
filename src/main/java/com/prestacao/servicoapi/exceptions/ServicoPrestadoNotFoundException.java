package com.prestacao.servicoapi.exceptions;

public class ServicoPrestadoNotFoundException extends RuntimeException {
    public ServicoPrestadoNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
