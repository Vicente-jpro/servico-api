package com.prestacao.servicoapi.exceptions;

public class TipoServicoFoundException extends RuntimeException {

    public TipoServicoFoundException(String errorMessage) {
        super(errorMessage);
    }
}
