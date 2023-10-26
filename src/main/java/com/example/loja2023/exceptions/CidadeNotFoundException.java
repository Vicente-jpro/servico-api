package com.example.loja2023.exceptions;

public class CidadeNotFoundException extends RuntimeException {

    public CidadeNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
