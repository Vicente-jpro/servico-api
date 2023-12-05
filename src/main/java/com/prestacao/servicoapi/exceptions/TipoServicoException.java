package com.prestacao.servicoapi.exceptions;

public class TipoServicoException extends RuntimeException {

    public TipoServicoException(String errorMessage) {
        super(errorMessage);
    }
}
