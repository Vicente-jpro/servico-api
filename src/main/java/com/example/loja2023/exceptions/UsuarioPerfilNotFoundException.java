package com.example.loja2023.exceptions;

public class UsuarioPerfilNotFoundException extends RuntimeException {

    public UsuarioPerfilNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
