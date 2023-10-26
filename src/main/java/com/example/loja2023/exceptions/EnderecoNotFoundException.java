package com.example.loja2023.exceptions;

public class EnderecoNotFoundException extends RuntimeException {
    public EnderecoNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
