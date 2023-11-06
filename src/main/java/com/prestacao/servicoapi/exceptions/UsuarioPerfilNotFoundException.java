package com.prestacao.servicoapi.exceptions;

public class UsuarioPerfilNotFoundException extends RuntimeException {

    public UsuarioPerfilNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
