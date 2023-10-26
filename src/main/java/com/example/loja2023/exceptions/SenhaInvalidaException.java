package com.example.loja2023.exceptions;

public class SenhaInvalidaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SenhaInvalidaException(String erroString) {
        super(erroString);
    }

}
